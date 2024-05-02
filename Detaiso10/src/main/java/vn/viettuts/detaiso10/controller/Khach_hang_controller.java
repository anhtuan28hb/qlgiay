package vn.viettuts.detaiso10.controller;

import XML.khachhangXML;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import vn.viettuts.detaiso10.entity.Customer;
import vn.viettuts.detaiso10.view.Khachhangview;
import com.toedter.calendar.JDateChooser;

public class Khach_hang_controller {

    private Document doc;
    private final JTable jtb_bang_khach_hang;
    private final JTextField txt_tenkh;
    private final JTextField txt_diachi;
    private final JTextField txt_sdt;
    private final JTextField txt_gioitinh;
    private JDateChooser ngaymua;
    private ArrayList<Customer> listkh;

    public Khach_hang_controller(Document doc, JTable jtb_bang_khach_hang, JTextField txt_tenkh, JTextField txt_diachi, JTextField txt_sdt, JTextField txt_gioitinh, JDateChooser ngaymua, ArrayList<Customer> listkh) {
        this.doc = doc;
        this.jtb_bang_khach_hang = jtb_bang_khach_hang;
        this.txt_tenkh = txt_tenkh;
        this.txt_diachi = txt_diachi;
        this.txt_sdt = txt_sdt;
        this.txt_gioitinh = txt_gioitinh;
        this.ngaymua = ngaymua;
        this.listkh = listkh;
    }

    public void hienthi() {

        try {
            File filekh = new File("khachhang.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(filekh);
            doc.getDocumentElement().normalize();
            NodeList nlkh = doc.getElementsByTagName("khachhang");
            listkh = new ArrayList<>();

            for (int i = 0; i < nlkh.getLength(); i++) {
                Element e = (Element) nlkh.item(i);

                String ten = e.getElementsByTagName("ten").item(0).getTextContent();
                String diachi = e.getElementsByTagName("diachi").item(0).getTextContent();
                String sdt = e.getElementsByTagName("sdt").item(0).getTextContent();
                String gioitinh = e.getElementsByTagName("gioitinh").item(0).getTextContent();
                String ngay_mua = e.getElementsByTagName("ngaymua").item(0).getTextContent();

                listkh.add(new Customer(ten, diachi, sdt, gioitinh, ngay_mua));
            }
            
            DefaultTableModel dftm = new DefaultTableModel();
            dftm.addColumn("Tên");
            dftm.addColumn("Địa chỉ");
            dftm.addColumn("Số điện thoại");
            dftm.addColumn("giới tính");
            dftm.addColumn("Ngày mua");

            for (Customer customer : listkh) {
                Object[] row = {customer.getTenkh(), customer.getDiachi(), customer.getSdt(), customer.getGioitinh(), customer.getNgaymua()};
                dftm.addRow(row);
            }
            jtb_bang_khach_hang.setModel(dftm);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Khachhangview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void themKhachHang() {
        String ten, diachi, sdt, gioitinh;

        ten = txt_tenkh.getText();
        diachi = txt_diachi.getText();
        sdt = txt_sdt.getText();
        gioitinh = txt_gioitinh.getText();

       
        

        SimpleDateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");

        String ngaymuaa = ngay.format(ngaymua.getDate());

        if (!duthongtin(ten, diachi, sdt)) {
            JOptionPane.showMessageDialog(null, "Điền đủ thông tin khách hàng", " ", JOptionPane.WARNING_MESSAGE);
        } else {

            Customer kh = new Customer(ten, diachi, sdt, gioitinh, ngaymuaa);
            Element e = doc.getDocumentElement();
            themkhachhang(doc, e, kh);
            ghiFile();
            hienthi();
            clear();
        }
    }

   public void suaKhachHang() {
    int selectedRow = jtb_bang_khach_hang.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần sửa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String ten, diachi, sdt, gioitinh;
    Date ngay;
    ten = txt_tenkh.getText();
    diachi = txt_diachi.getText();
    sdt = txt_sdt.getText();
    gioitinh = txt_gioitinh.getText();
    ngay = ngaymua.getDate();

    NodeList khachHangNodes = doc.getElementsByTagName("khachhang");
    Element selectedKhachHangElement = (Element) khachHangNodes.item(selectedRow);
    selectedKhachHangElement.getElementsByTagName("ten").item(0).setTextContent(ten);
    selectedKhachHangElement.getElementsByTagName("diachi").item(0).setTextContent(diachi);
    selectedKhachHangElement.getElementsByTagName("sdt").item(0).setTextContent(sdt);
    selectedKhachHangElement.getElementsByTagName("gioitinh").item(0).setTextContent(gioitinh);
    selectedKhachHangElement.getElementsByTagName("ngaymua").item(0).setTextContent(new SimpleDateFormat("dd-MM-yyyy").format(ngay));

    ghiFile();
    hienthi();
    clear();
}


    public void xoaKhachHang() {
        int selectedRow = jtb_bang_khach_hang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String ten = (String) jtb_bang_khach_hang.getValueAt(selectedRow, 0);
        String diachi = (String) jtb_bang_khach_hang.getValueAt(selectedRow, 1);
        String sdt = (String) jtb_bang_khach_hang.getValueAt(selectedRow, 2);

        txt_tenkh.setText(ten);
        txt_diachi.setText(diachi);
        txt_sdt.setText(sdt);

        int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa khách hàng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            try {
                XPathFactory xpf = XPathFactory.newInstance();
                XPath xp = xpf.newXPath();
                Node khachHangNode = (Node) xp.evaluate("//khachhang[ten='" + ten + "' and diachi='" + diachi + "' and sdt='" + sdt + "']", doc, XPathConstants.NODE);
                if (khachHangNode != null) {
                    Node parent = khachHangNode.getParentNode();
                    parent.removeChild(khachHangNode);
                    ghiFile();
                    JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    hienthi();
                    clear();
                }
            } catch (XPathExpressionException ex) {
                Logger.getLogger(Khach_hang_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void ghiFile() {
        TransformerFactory tff = TransformerFactory.newInstance();
        try {

            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "khachhang.xml";

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            tf.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(khachhangXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(khachhangXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clear() {
        txt_tenkh.setText("");
        txt_diachi.setText("");
        txt_sdt.setText("");
        txt_gioitinh.setText("");
        ngaymua.setDate(null);
    }

    private boolean duthongtin(String ten, String diachi, String sdt) {
        return !ten.trim().isEmpty() && !diachi.trim().isEmpty() && !sdt.trim().isEmpty();
    }

    // Kiểm tra xem thông tin khách hàng đã tồn tại chưa
    private boolean trung(String ten, String diachi, String sdt) {
        boolean datrung = false;
        String tenkh, diachikh, sdtkh;
        tenkh = txt_tenkh.getText();
        diachikh = txt_diachi.getText();
        sdtkh = txt_sdt.getText();
        if (ten.equals(tenkh) && diachi.equals(diachi) && sdt.equals(sdtkh)) {
            datrung = true;
        }
        return datrung;
    }

    static private void themkhachhang(Document doc, Element e, Customer kh) {
        Element khachhang = doc.createElement("khachhang");
        Element ten = doc.createElement("ten");
        ten.setTextContent(kh.getTenkh());
        Element diachi = doc.createElement("diachi");
        diachi.setTextContent(kh.getDiachi());
        Element sdt = doc.createElement("sdt");
        sdt.setTextContent(kh.getSdt());
        Element gioitinh = doc.createElement("gioitinh");
        gioitinh.setTextContent(kh.getGioitinh());
        Element ngaymua = doc.createElement("ngaymua");
        ngaymua.setTextContent(kh.getNgaymua());

        khachhang.appendChild(ten);
        khachhang.appendChild(diachi);
        khachhang.appendChild(sdt);
        khachhang.appendChild(gioitinh);
        khachhang.appendChild(ngaymua);

        e.appendChild(khachhang);

    }
}
