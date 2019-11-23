package projXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.StAXEventBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.w3c.dom.Node;

import bo.Block;
import bo.Elmsimpl;
import bo.Sale;
import bo.etage;
import bo.hoccp;

public class ManpXML {
	
	public static Element addhoccp(File  xmlFile,Document document,hoccp o) throws JDOMException, IOException
	{
		Element hoccp = new Element("hoccp");
		Element h = new Element("h");
		h.setText(((hoccp) o).getH());
		hoccp.addContent(h);
		return hoccp ;
	}
	public static Element addSale(File  xmlFile,Document document,Sale o) throws JDOMException, IOException
	{
		
		Element Sale = new Element("sale");

		 Element num = new Element("num");
		num.setText( String.valueOf(((Sale) o).getNum()));
		Sale.addContent(num);
		for (hoccp att :((Sale) o).getL())
		{
			
			Sale.addContent(addhoccp(  xmlFile, document,att));

		}
		Element cap = new Element("cap");
		cap.setText( String.valueOf(((Sale) o).getCapp()));
		Sale.addContent(cap);
		
		return Sale ;
	}
	public static Element addetage(File  xmlFile,Document document,etage o) throws JDOMException, IOException
	{

		 Element etage = new Element("etage");
		
		 Element num = new Element("num");
		num.setText( String.valueOf(((etage) o).getNum()));
		etage.addContent(num);
		for (Sale att : o.getL())
		{
			
			etage.addContent(addSale(  xmlFile, document,att));

		}
		
		return etage ;
	}
	public static Element addBlock(File  xmlFile,Document document,Block o) throws JDOMException, IOException
	{

		 Element Block = new Element("Block");
		
		 Element nom = new Element("nom");
		nom.setText( String.valueOf( o.getNom()));
		Block.addContent(nom);
		for (etage att : o.getL())
		{
			Block.addContent(addetage(  xmlFile, document,att));
		}
		
		return Block ;
	}
	

	public static void addElement(File  xmlFile,Document document,Object o,int[] t) throws JDOMException, IOException {
		
		Element root1 = null;
		Element root = null;
		FileInputStream fis = new FileInputStream(xmlFile);
		 SAXBuilder sb = new SAXBuilder();
		 document = sb.build(fis);
		 root1 = document.detachRootElement();
		 Element e=null;
		 if(o instanceof Elmsimpl)
		 {
			o=(Elmsimpl)o;
			Element elms = new Element(((Elmsimpl) o).getType());
			elms.setText(((Elmsimpl) o).getVal());
			e = elms;
		 }
		 if(o instanceof hoccp)
		 {
			o=(hoccp)o;
			e = addhoccp(  xmlFile, document, (bo.hoccp) o);
		 }
		 if(o instanceof Sale) 
		 {
			 o=(Sale)o;
				e= addSale(  xmlFile, document, (bo.Sale) o);
		 }
		 if(o instanceof etage) 
		 {
			 o=(etage)o;
			 
			e = addetage(  xmlFile, document, (bo.etage) o);
		 }
		 if(o instanceof Block) 
		 {
			 o=(Block)o;
			e= addBlock(  xmlFile, document, (bo.Block) o);
		 }
		 root=root1.getChildren().get(t[0]);
	for(int i=1;i<t.length-1;i++) {
		root=root.getChildren().get(t[i]);
	}
	root.addContent(t[t.length-1], e);
       	document.addContent(root1);
	
		 
		XMLOutputter xmlOutput = new XMLOutputter();

        // display ml
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
			xmlOutput.output(document, new FileWriter(xmlFile.getAbsolutePath()));
			System.out.println("ajout avec succes !!");
		} catch (IOException E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		} 

	}
	
	public static void updateElement(File  xmlFile,Document document,Object o,int[] t) throws JDOMException, IOException {
		
		Element root1 = null;
		Element root = null;
		FileInputStream fis = new FileInputStream(xmlFile);
		 SAXBuilder sb = new SAXBuilder();
		 document = sb.build(fis);
		 root1 = document.detachRootElement();
		 Element e=null;
		 root=root1.getChildren().get(t[0]);
			for(int i=1;i<t.length-1;i++) {
				root=root.getChildren().get(t[i]);
			}
		 
		 if(o instanceof Elmsimpl)
		 {
			o=(Elmsimpl)o;
			root.getChildren().get(t[t.length-1]).setText(((Elmsimpl) o).getVal());
		 }
		 if(o instanceof hoccp)
		 {
			o=(hoccp)o;
			root.removeContent(t[t.length-1]);
			root.addContent(t[t.length-1], addhoccp(xmlFile, document, (hoccp) o));
		 }
		 if(o instanceof Sale) 
		 {
			 o=(Sale)o;
				root.removeContent(t[t.length-1]);
				root.addContent(t[t.length-1], addSale(xmlFile, document, (Sale) o));

		 }
		 if(o instanceof etage) 
		 {
			 o=(etage)o;
			 root.removeContent(t[t.length-1]);
				root.addContent(t[t.length-1], addetage(xmlFile, document, (etage) o));
		 }
		 if(o instanceof Block) 
		 {
			 o=(Block)o;
			 root.removeContent(t[t.length-1]);
				root.addContent(t[t.length-1], addBlock(xmlFile, document, (Block) o));
		 }
		 
		       	document.addContent(root1);
			
				 
				XMLOutputter xmlOutput = new XMLOutputter();

		        // display ml
		        xmlOutput.setFormat(Format.getPrettyFormat());
		        try {
					xmlOutput.output(document, new FileWriter(xmlFile.getAbsolutePath()));
					System.out.println("update avec succes !!");
				} catch (IOException E) {
					// TODO Auto-generated catch block
					E.printStackTrace();
				} 

		 
	}

	public static void deleteElement(File  xmlFile,Document document,int[] t) throws JDOMException, IOException {
		

		Element root1 = null;
		Element root = null;
		FileInputStream fis = new FileInputStream(xmlFile);
		 SAXBuilder sb = new SAXBuilder();
		 document = sb.build(fis);
		 root1 = document.detachRootElement();
		 root=root1.getChildren().get(t[0]);
			for(int i=1;i<t.length-1;i++) {
				root=root.getChildren().get(t[i]);
			}
			root.removeContent(t[t.length-1]);
		       	document.addContent(root1);
			
				 
				XMLOutputter xmlOutput = new XMLOutputter();

		        // display ml
		        xmlOutput.setFormat(Format.getPrettyFormat());
		        try {
					xmlOutput.output(document, new FileWriter(xmlFile.getAbsolutePath()));
					System.out.println("suppression avec succes !!");
				} catch (IOException E) {
					// TODO Auto-generated catch block
					E.printStackTrace();
				} 

	}
	
	public static List<Element> getAllElements(File f,Document document) throws JDOMException, IOException {
		
		 document = getSAXParsedDocument(f.getAbsolutePath());
		 
			XPathFactory xpfac = XPathFactory.instance();
			
			//Read employee first names
			XPathExpression<Element> xPathN = xpfac.compile("/*", Filters.element());
			
			return  xPathN.evaluate(document);
	}

	
	public static Object getElement(File f,Document document,String s) throws JDOMException, IOException {
		

		 document = getSAXParsedDocument(f.getAbsolutePath());
		 
		XPathFactory xpfac = XPathFactory.instance();
		
		//Read employee first names
		XPathExpression<Element> xPathN = xpfac.compile(s, Filters.element());
		
		return  xPathN.evaluateFirst(document);
			  
		 }
	
	private static Document getSAXParsedDocument(final String fileName)
	{
	    SAXBuilder builder = new SAXBuilder();
	    Document document = null;
	    try
	    {
	        document = builder.build(fileName);
	    }
	    catch (JDOMException | IOException e)
	    {
	        e.printStackTrace();
	    }
	    return document;
	}
	
	public static void affelm(Element e,String s) {
		
		System.out.println(s+e.getName());
		for(Element l : e.getChildren()) {
			if(l.getChildren().size()>1) {
				affelm(l,"     ");
			}
			else {
				System.out.println("     "+l.getName());
				System.out.println("     "+l.getValue());	
			}
		}
		
	}

}
