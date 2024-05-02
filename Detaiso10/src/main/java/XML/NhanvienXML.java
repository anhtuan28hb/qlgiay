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

public class NhanvienXML {
     public static void taonhanvienxml() {
         try {
            String filePath = "nhanvien.xml";
            File file = new File(filePath);

            if (!file.exists()) {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.newDocument();

                Element nhanviens = doc.createElement("nhanviens");
                doc.appendChild(nhanviens);

                TransformerFactory tff = TransformerFactory.newInstance();
                try {
                    Transformer tf = tff.newTransformer();
                    tf.setOutputProperty(OutputKeys.INDENT, "yes");
                    tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(file);
                    tf.transform(source, result);
                } catch (TransformerConfigurationException ex) {
                    Logger.getLogger(NhanvienXML.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(NhanvienXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
