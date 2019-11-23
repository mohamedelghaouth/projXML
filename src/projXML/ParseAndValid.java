package projXML;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

public class ParseAndValid {

   public static Document pv(File f) throws JDOMException, IOException {
	   SAXBuilder builder2 = new SAXBuilder(XMLReaders.XSDVALIDATING);
       return builder2.build(f);
   
   }

}