package projXML;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import bo.hoccp;

public class Main {
	
	public static void main(String[] args) {
		
		String s="/ecole/block[1]/etage[1]/sale[1]";
		File f=new File("p1.xml");
		Document d;
		try {
			d = ParseAndValid.pv( f);
		
		hoccp h=new hoccp("10:15:15");
		//tableau con tient la position 
		int[] t= {2,1,1,3};
		
		//ManpXML.affelm((Element) ManpXML.getElement( f, d,s),"");
		//ManpXML.deleteElement( f, d, t);
		//ManpXML.updateElement( f, d,h, t);
	//	ManpXML.addElement( f, d,h, t);
//			List<Element> e =  ManpXML.getAllElements( f, d);
//			for(Element l: e) {
//				ManpXML.affelm(l,"");
//			}
		} catch (JDOMException |NullPointerException| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
