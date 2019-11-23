package projXML;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.transform.JDOMResult;

public class Transform {

	static org.jdom.Document document;

	
	public static void outputXSLT(org.jdom.Document documentJDOMEntree,String fichierXSL)
	{
	//Document JDOMResult, résultat de la transformation TraX
	JDOMResult documentJDOMSortie = new JDOMResult();
	//Document JDOM après transformation
	org.jdom.Document resultat = null;
	try
	{
	//On définit un transformer avec la source XSL
	//qui va permettre la transformation
	TransformerFactory factory = TransformerFactory.newInstance();
	Transformer transformer = factory.newTransformer(new
	StreamSource(fichierXSL));
	//On transforme le document JDOMEntree grâce à notre transformer.
	//La méthode transform() prend en argument le document d'entrée
	//associé au transformer et un document JDOMResult, résultat de
	//la transformation TraX
	transformer.transform(new
	org.jdom.transform.JDOMSource(documentJDOMEntree),
	documentJDOMSortie);
	//Pour récupérer le document JDOM issu de cette transformation
	//il faut utiliser la méthode getDocument()
	resultat = documentJDOMSortie.getDocument();
	//On crée un fichier xml corespondant au résultat
	XMLOutputter outputter = new
	XMLOutputter(Format.getPrettyFormat());
	outputter.output(resultat, new FileOutputStream("resultat.xml"));
	}
	catch(Exception e){}
	}
	
	
	public static void main(String[] args)
	{
	//On crée une instance de SAXBuilder
	SAXBuilder sxb = new SAXBuilder();
	try
	{
	//On crée un nouveau document JDOM avec en argument le fichier XML
	//Le parsing est terminé ;)
	document = sxb.build(new File("p1.xml"));
	outputXSLT(document,"xsldemo.xsl");
	}
	catch(Exception e){}
	}
}
