
package XML;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import vn.viettuts.detaiso10.entity.Customer;

public class khachhangXML {

    public static void taokhachhangxml() {
        try {
            String filePath = "khachhang.xml";
            File file = new File(filePath);

            if (!file.exists()) {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.newDocument();

                Element khachhangs = doc.createElement("khachhangs");
                doc.appendChild(khachhangs);

                TransformerFactory tff = TransformerFactory.newInstance();
                try {
                    Transformer tf = tff.newTransformer();
                    tf.setOutputProperty(OutputKeys.INDENT, "yes");
                    tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(file);
                    tf.transform(source, result);
                } catch (TransformerConfigurationException ex) {
                    Logger.getLogger(khachhangXML.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(khachhangXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}


