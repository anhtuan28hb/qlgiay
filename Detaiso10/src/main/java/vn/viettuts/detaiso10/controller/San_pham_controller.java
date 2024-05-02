package vn.viettuts.detaiso10.controller;

import XML.SanphamXML;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import vn.viettuts.detaiso10.entity.Shoes;
import vn.viettuts.detaiso10.view.Sanphamview;

public class San_pham_controller {

    private Document doc;
    private final JTextField themsuanametextfield;
    private final JTextField themsuamautextfield;
    private final JTextField themsuasizetextfield;
    private final JTextField themsuagiatextfield;
    private final String anhsp;
    private final JTable sanphamtable;
    private final JLabel picturelabel;
    private ArrayList<Shoes> list;

    public San_pham_controller(Document doc, JTextField themsuanametextfield, JTextField themsuamautextfield, JTextField themsuasizetextfield, JTextField themsuagiatextfield, String anhsp, JTable sanphamtable, JLabel picturelabel, ArrayList<Shoes> list) {
        this.doc = doc;
        this.themsuanametextfield = themsuanametextfield;
        this.themsuamautextfield = themsuamautextfield;
        this.themsuasizetextfield = themsuasizetextfield;
        this.themsuagiatextfield = themsuagiatextfield;
        this.anhsp = anhsp;
        this.sanphamtable = sanphamtable;
        this.picturelabel = picturelabel;
        this.list = list;
    }

    public void hienthi() {
        try {
            File xmlFile = new File("sanpham.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nlsanpham = doc.getElementsByTagName("sanpham");
            list = new ArrayList<>();

            for (int i = 0; i < nlsanpham.getLength(); i++) {
                Element element = (Element) nlsanpham.item(i);
                String ten = element.getElementsByTagName("ten").item(0).getTextContent();
                String mau = element.getElementsByTagName("mau").item(0).getTextContent();
                String size = element.getElementsByTagName("size").item(0).getTextContent();

                int gia = Integer.parseInt(element.getElementsByTagName("gia").item(0).getTextContent());
                String anh = element.getElementsByTagName("anh").item(0).getTextContent();
                list.add(new Shoes(ten, mau, size, gia, anh));
            }
            DefaultTableModel dftm = new DefaultTableModel();
            dftm.addColumn("Tên");
            dftm.addColumn("Màu");
            dftm.addColumn("Size");
            dftm.addColumn("Giá");

            for (Shoes sp : list) {
                Object[] row = {sp.getTen(), sp.getMau(), sp.getSize(), sp.getGia()};
                dftm.addRow(row);
            }

            sanphamtable.setModel(dftm);
            sanphamtable.getColumnModel().getColumn(0).setPreferredWidth(220);
            sanphamtable.getColumnModel().getColumn(1).setPreferredWidth(90);
            sanphamtable.getColumnModel().getColumn(2).setPreferredWidth(40);
            sanphamtable.getColumnModel().getColumn(3).setPreferredWidth(90);
        } catch (ParserConfigurationException | org.xml.sax.SAXException | java.io.IOException ex) {
            Logger.getLogger(Sanphamview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void themsanpham(Document doc, Element e, Shoes sp) {
        Element sanpham = doc.createElement("sanpham");
        Element ten = doc.createElement("ten");
        ten.setTextContent(sp.getTen());

        Element mau = doc.createElement("mau");
        mau.setTextContent(sp.getMau());

        Element size = doc.createElement("size");
        size.setTextContent(String.valueOf(sp.getSize()));

        Element gia = doc.createElement("gia");
        gia.setTextContent(String.valueOf(sp.getGia()));

        Element anh = doc.createElement("anh");
        anh.setTextContent(sp.getAnh());

        sanpham.appendChild(ten);
        sanpham.appendChild(mau);
        sanpham.appendChild(size);
        sanpham.appendChild(gia);
        sanpham.appendChild(anh);

        e.appendChild(sanpham);
    }

    private void ghiFile() {
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "sanpham.xml";

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            tf.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(SanphamXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(SanphamXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean dayduthongtin(String tensp, String mausp, String sizesp, int giasp) {
        return !tensp.trim().isEmpty() && !mausp.trim().isEmpty() && !sizesp.isEmpty() && giasp > 0;
    }

    private boolean datrungsp(String tensp, String mausp, String sizesp, int giasp) {
        for (Shoes sp : list) {
            if (sp.getTen().equalsIgnoreCase(tensp) && sp.getMau().equalsIgnoreCase(mausp) && sp.getSize().equalsIgnoreCase(sizesp) && sp.getGia() == giasp) {
                return true;
            }
        }
        return false;
    }

    private void clear() {
        themsuanametextfield.setText("");
        themsuamautextfield.setText("");
        themsuagiatextfield.setText("");
        themsuasizetextfield.setText("");
        picturelabel.setIcon(null);
    }

    public void hien_anh(String anh, JLabel jlb) {
        if (anh != null) {
            ImageIcon imgI = new ImageIcon(anh);
            Image img = imgI.getImage();
            Image scaledImg = img.getScaledInstance(497, 280, Image.SCALE_SMOOTH);
            ImageIcon scaledImgI = new ImageIcon(scaledImg);
            scaledImgI.setDescription(anh);
            jlb.setIcon(scaledImgI);
        } else {
            jlb.setIcon(null);
        }
    }
   

    private static String chonanh() {
        JFileChooser chon_file = new JFileChooser();

        String defaultPath = "src/main/resources/anhthem";
        chon_file.setCurrentDirectory(new File(defaultPath));

        FileNameExtensionFilter ft = new FileNameExtensionFilter("img", "jpg", "jpeg", "png", "gif");
        chon_file.setFileFilter(ft);

        int n = chon_file.showOpenDialog(null);

        if (n == JFileChooser.APPROVE_OPTION) {
            File f = chon_file.getSelectedFile();
            return f.getAbsolutePath();
        } else {
            return null;
        }
    }

    public String lay_anh(String ten, String mau, String size, int gia) {
        for (Shoes sp : list) {
            if (sp.getTen().equalsIgnoreCase(ten) && sp.getMau().equalsIgnoreCase(mau)
                    && sp.getSize() == size && sp.getGia() == gia) {
                return sp.getAnh();
            }
        }
        return null;
    }

    private String lay_tu_jlb(JLabel jlb) {
        ImageIcon img = (ImageIcon) jlb.getIcon();
        if (img != null) {
            String absolutePath = new File(img.getDescription()).getAbsolutePath();
        String relativePath = absolutePath.substring(absolutePath.indexOf("src"));
        return relativePath;
        } else {
            return null;
        }

    }

    private void capNhatAnhSanPham(String ten, String mau, String size, int gia, String anh) {
        for (Shoes sp : list) {
            if (sp.getTen().equalsIgnoreCase(ten) && sp.getMau().equalsIgnoreCase(mau)
                    && sp.getSize() == size && sp.getGia() == gia) {
                sp.setAnh(anh);
                break;
            }
        }
    }

    private void xoaGiay(String ten, String mau, String size, int gia) {
        for (int i = 0; i < list.size(); i++) {
            Shoes sp = list.get(i);
            if (sp.getTen().equalsIgnoreCase(ten) && sp.getMau().equalsIgnoreCase(mau)
                    && sp.getSize() == size && sp.getGia() == gia) {
                list.remove(i);
                break;
            }
        }
    }

    public void them_san_pham() {
        String tensp, mausp, sizesp, anh;
        int giasp;
        tensp = themsuanametextfield.getText();
        mausp = themsuamautextfield.getText();
        sizesp = themsuasizetextfield.getText();
        giasp = Integer.parseInt(themsuagiatextfield.getText());
        anh = lay_tu_jlb(picturelabel);
        if (!dayduthongtin(tensp, mausp, sizesp, giasp)) {
            JOptionPane.showMessageDialog(null, "vui lòng nhập đủ thông tin sản phẩm", " ", JOptionPane.WARNING_MESSAGE);
        } else {
            if (datrungsp(tensp, mausp, sizesp, giasp)) {
                JOptionPane.showMessageDialog(null, "sản phẩm đã có", "", JOptionPane.WARNING_MESSAGE);

            } else {
                Shoes sp = new Shoes(tensp, mausp, sizesp, giasp, anh);
                Element sanphamm = doc.getDocumentElement();
                themsanpham(doc, sanphamm, sp);

                ghiFile();
                hienthi();
                clear();
            }
        }
    }

    public void xoa_san_pham() {
        try {
            String ten, sizesp, mau;
            int giasp;
            int hangChon = sanphamtable.getSelectedRow();
            ten = themsuanametextfield.getText();
            mau = themsuamautextfield.getText();
            sizesp = themsuasizetextfield.getText();
            giasp = Integer.parseInt(themsuagiatextfield.getText());

            if (dayduthongtin(ten, mau, sizesp, giasp)) {
                int n = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    NodeList nl = doc.getElementsByTagName("sanpham");
                    Node nodeToDelete = null;
                    for (int i = 0; i < nl.getLength(); i++) {
                        Element element = (Element) nl.item(i);
                        String tenSP = element.getElementsByTagName("ten").item(0).getTextContent();
                        String mauSP = element.getElementsByTagName("mau").item(0).getTextContent();
                        String sizeSP = element.getElementsByTagName("size").item(0).getTextContent();

                        int giaSP = Integer.parseInt(element.getElementsByTagName("gia").item(0).getTextContent());

                        if (tenSP.equalsIgnoreCase(ten) && mauSP.equalsIgnoreCase(mau) && sizeSP.equalsIgnoreCase(sizesp) && giaSP == giasp) {
                            nodeToDelete = nl.item(i);
                            break;
                        }
                    }
                    if (nodeToDelete != null) {
                        doc.getDocumentElement().removeChild(nodeToDelete);

                        ghiFile();
                        JOptionPane.showMessageDialog(null, "Xóa thành công", "", JOptionPane.INFORMATION_MESSAGE);
                        hienthi();
                        clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm để xóa", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin sản phẩm", "", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sua_san_pham() {

        int hangChon = sanphamtable.getSelectedRow();

        String tensp, mausp,sizesp, anh;
        int  giasp;

        tensp = themsuanametextfield.getText();
        mausp = themsuamautextfield.getText();
        sizesp = themsuasizetextfield.getText();
        giasp = Integer.parseInt(themsuagiatextfield.getText());
        anh = lay_tu_jlb(picturelabel);
        NodeList nl = doc.getElementsByTagName("sanpham");
        Element spE = (Element) nl.item(hangChon);
        spE.getElementsByTagName("ten").item(0).setTextContent(tensp);
        spE.getElementsByTagName("mau").item(0).setTextContent(mausp);
        spE.getElementsByTagName("size").item(0).setTextContent(String.valueOf(sizesp));
        spE.getElementsByTagName("gia").item(0).setTextContent(String.valueOf(giasp));
        spE.getElementsByTagName("anh").item(0).setTextContent(anh);

        ghiFile();
        hienthi();

        clear();
    }

    public void them_anh() {
        String anh = chonanh();
        if (anh != null) {
            picturelabel.setIcon(new ImageIcon(anh));
            int hangChon = sanphamtable.getSelectedRow();
            String tensp = themsuanametextfield.getText();
            String mausp = themsuamautextfield.getText();
            String sizesp = themsuasizetextfield.getText();
            int giasp = Integer.parseInt(themsuagiatextfield.getText());
            capNhatAnhSanPham(tensp, mausp, sizesp, giasp, anh);
            ghiFile();
        }
    }
    
}
