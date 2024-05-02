/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.viettuts.detaiso10.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import vn.viettuts.detaiso10.entity.Donhang;

/**
 *
 * @author Bui Anh Tuan
 */
public class laydulieutudonhangxml {
    ArrayList<Donhang> listdh;
    private HashMap<String, Donhang> mapDonhang;
//    private DecimalFormat n = new DecimalFormat();

    public laydulieutudonhangxml(){
     mapDonhang = new HashMap<>();
        try {
            File xmlFile = new File("donhang.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nldonhang = doc.getElementsByTagName("sanpham");

            for (int i = 0; i < nldonhang.getLength(); i++) {
                Element element = (Element) nldonhang.item(i);
                String ten = element.getElementsByTagName("ten").item(0).getTextContent();
                int gia = Integer.parseInt(element.getElementsByTagName("gia").item(0).getTextContent());
                int sl = Integer.parseInt(element.getElementsByTagName("soluong").item(0).getTextContent());
                int dt = gia*sl;
                if (mapDonhang.containsKey(ten)) {
                    Donhang donhang = mapDonhang.get(ten);
                    donhang.setSoluong(donhang.getSoluong() + sl);
                    donhang.setDoanhthu(donhang.getDoanhthu() + dt);
                } else {
                    mapDonhang.put(ten, new Donhang(ten, sl, dt));
                }
            }

            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(laydulieutudonhangxml.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

    public HashMap<String, Donhang> getMapDonhang() {
        return mapDonhang;
    }
         
        

}