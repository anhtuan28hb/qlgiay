package vn.viettuts.detaiso10.controller;

import XML.NhanvienXML;
import XML.SanphamXML;
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
import vn.viettuts.detaiso10.entity.Nhanvien;
import vn.viettuts.detaiso10.entity.Shoes;
import vn.viettuts.detaiso10.view.Aboutview;
import vn.viettuts.detaiso10.view.Sanphamview;

/**
 *
 * @author Bui Anh Tuan
 */
public class Nhan_vien_controller {

    private Document doc;
    private final JTextField ten;
    private final JTextField diachi;
    private final JTextField sdt;
    private final JTextField chucvu;
    private final JTextField luong;
    private final JTextField gioitinh;
    private final String anh;
    private final JLabel anhnhanvien;
    private final JTable bangnhanvien;
    ArrayList<Nhanvien> list;

    public Nhan_vien_controller(Document doc, JTextField ten, JTextField diachi, JTextField sdt, JTextField chucvu, JTextField luong, JTextField gioitinh, String anh, JLabel anhnhanvien, JTable bangnhanvien, ArrayList<Nhanvien> list) {
        this.doc = doc;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.chucvu = chucvu;
        this.luong = luong;
        this.gioitinh = gioitinh;
        this.anh = anh;
        this.anhnhanvien = anhnhanvien;
        this.bangnhanvien = bangnhanvien;
        this.list = list;
    }

    public void hienthi() {
        try {
            File xmlFile = new File("nhanvien.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nlsanpham = doc.getElementsByTagName("nhanvienn");
            list = new ArrayList<>();

            for (int i = 0; i < nlsanpham.getLength(); i++) {
                Element element = (Element) nlsanpham.item(i);
                String tennv = element.getElementsByTagName("ten").item(0).getTextContent();
                String diachinv = element.getElementsByTagName("diachi").item(0).getTextContent();
                String sdtnv = element.getElementsByTagName("sodienthoai").item(0).getTextContent();
                String chucvunv = element.getElementsByTagName("chucvu").item(0).getTextContent();
                String luongnv = element.getElementsByTagName("luong").item(0).getTextContent();
                String gioitinhnv = element.getElementsByTagName("gioitinh").item(0).getTextContent();
                String anhnv = element.getElementsByTagName("anh").item(0).getTextContent();

                list.add(new Nhanvien(tennv, diachinv, sdtnv, chucvunv, luongnv, gioitinhnv, anhnv));

            }

            DefaultTableModel dftm = new DefaultTableModel();
            dftm.addColumn("Tên");
            dftm.addColumn("Địa chỉ");
            dftm.addColumn("Số điện thoại");
            dftm.addColumn("Chức vụ");
            dftm.addColumn("Lương");
            dftm.addColumn("Giới tính");

            for (Nhanvien nv : list) {
                Object[] row = {nv.getTen(), nv.getDiachi(), nv.getSdt(), nv.getChucvu(), nv.getLuong(), nv.getGioitinh()};
                dftm.addRow(row);
            }

            bangnhanvien.setModel(dftm);
            bangnhanvien.getColumnModel().getColumn(0).setPreferredWidth(120);
            bangnhanvien.getColumnModel().getColumn(1).setPreferredWidth(120);
            bangnhanvien.getColumnModel().getColumn(2).setPreferredWidth(100);
            bangnhanvien.getColumnModel().getColumn(3).setPreferredWidth(90);
            bangnhanvien.getColumnModel().getColumn(4).setPreferredWidth(50);
            bangnhanvien.getColumnModel().getColumn(5).setPreferredWidth(50);
        } catch (ParserConfigurationException | org.xml.sax.SAXException | java.io.IOException ex) {
            Logger.getLogger(Aboutview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void themnhanvien(Document doc, Element e, Nhanvien nv) {
        Element nhanvienn = doc.createElement("nhanvienn");
        Element tennv = doc.createElement("ten");
        tennv.setTextContent(nv.getTen());
        Element diachinv = doc.createElement("diachi");
        diachinv.setTextContent(nv.getDiachi());
        Element sdtnv = doc.createElement("sodienthoai");
        sdtnv.setTextContent(nv.getSdt());
        Element chucvunv = doc.createElement("chucvu");
        chucvunv.setTextContent(nv.getChucvu());
        Element luongnv = doc.createElement("luong");
        luongnv.setTextContent(nv.getLuong());
        Element gioitinhnv = doc.createElement("gioitinh");
        gioitinhnv.setTextContent(nv.getGioitinh());
        Element anhnv = doc.createElement("anh");
        anhnv.setTextContent(nv.getAnh());

        nhanvienn.appendChild(tennv);
        nhanvienn.appendChild(diachinv);
        nhanvienn.appendChild(sdtnv);
        nhanvienn.appendChild(chucvunv);
        nhanvienn.appendChild(luongnv);
        nhanvienn.appendChild(gioitinhnv);
        nhanvienn.appendChild(anhnv);

        e.appendChild(nhanvienn);
    }

    private void ghiFile() {
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "nhanvien.xml";

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            tf.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(NhanvienXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(NhanvienXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hien_anh(String anhnv, JLabel jlb) {
        if (anhnv != null) {
            ImageIcon imgI = new ImageIcon(anhnv);

            Image img = imgI.getImage();

            Image scaledImg = img.getScaledInstance(230, 170, Image.SCALE_SMOOTH);

            ImageIcon scaledImgI = new ImageIcon(scaledImg);
            scaledImgI.setDescription(anhnv);

            jlb.setIcon(scaledImgI);
        } else {
            jlb.setIcon(null);
        }

    }

    private static String chonanh() {
        // Tạo một đối tượng JFileChooser
        JFileChooser chon_file = new JFileChooser();

        // Đặt thư mục mặc định là src/main/resources/anhthem
        String defaultPath = "src/main/resources/anhnhanvienthem";
        chon_file.setCurrentDirectory(new File(defaultPath));

        // Đặt bộ lọc cho các loại file hình ảnh
        FileNameExtensionFilter ft = new FileNameExtensionFilter("img", "jpg", "jpeg", "png", "gif");
        chon_file.setFileFilter(ft);

        // Hiển thị hộp thoại chọn file
        int n = chon_file.showOpenDialog(null);

        // Nếu người dùng chọn file và nhấn OK
        if (n == JFileChooser.APPROVE_OPTION) {
            File f = chon_file.getSelectedFile();
            return f.getAbsolutePath();
        } else {
            // Nếu người dùng không chọn file hoặc hủy bỏ
            return null;
        }
    }

    public String lay_anh(String ten, String diachi, String sdt, String chucvu, String luong) {
        for (Nhanvien nv : list) {
            if (nv.getTen().equalsIgnoreCase(ten) && nv.getDiachi().equalsIgnoreCase(diachi)
                    && nv.getSdt().equalsIgnoreCase(sdt) && nv.getChucvu().equalsIgnoreCase(chucvu) && nv.getLuong().equalsIgnoreCase(luong)) {

                return nv.getAnh();
            }
        }
        return null;
    }

    private String lay_tu_jlb(JLabel jlb) {
        ImageIcon img = (ImageIcon) jlb.getIcon();
//        hien_anh(anhsp, jlb);
        if (img != null) {
            String description = img.getDescription();
            if (description != null && !description.isEmpty()) {
                File file = new File(description);
                if (file.exists()) {
                    return file.getAbsolutePath();
                }
            }
        }
        return null;

    }

    private void capNhatAnhNhanVien(String ten, String diachi, String sdt, String chucvu, String luong, String anhnv) {
        for (Nhanvien nv : list) {
            if (nv.getTen().equalsIgnoreCase(ten) && nv.getDiachi().equalsIgnoreCase(diachi)
                    && nv.getSdt().equalsIgnoreCase(sdt) && nv.getChucvu().equalsIgnoreCase(chucvu) && nv.getLuong().equalsIgnoreCase(luong)) {
                nv.setAnh(anhnv);
                break;
            }
        }
    }

    private void xoaAnhnv(String ten, String diachi, String sdt, String chucvu, String luong) {
        for (int i = 0; i < list.size(); i++) {
            Nhanvien nv = list.get(i);
            if (nv.getTen().equalsIgnoreCase(ten) && nv.getDiachi().equalsIgnoreCase(diachi)
                    && nv.getSdt().equalsIgnoreCase(sdt) && nv.getChucvu().equalsIgnoreCase(chucvu) && nv.getLuong().equalsIgnoreCase(luong)) {
                list.remove(i);
                break;
            }
        }
    }

    public void them_nhan_vien() {
        String tennv, diachinv, sdtnv, chucvunv, luongnv, gioitinhnv, anhnv;
        tennv = ten.getText();
        diachinv = diachi.getText();
        sdtnv = sdt.getText();
        chucvunv = chucvu.getText();
        luongnv = luong.getText();
        gioitinhnv = gioitinh.getText();
        anhnv = lay_tu_jlb(anhnhanvien);
        
        System.out.println(tennv);
        System.out.println(gioitinhnv);
        
        if (!dayduthongtin(tennv, diachinv, sdtnv, chucvunv, luongnv, gioitinhnv)) {
            JOptionPane.showMessageDialog(null, "vui lòng nhập đủ thông tin nhân viên", " ", JOptionPane.WARNING_MESSAGE);
        } else {
            if (datrungnhanvien(tennv, diachinv, sdtnv, chucvunv, luongnv, gioitinhnv)) {
                JOptionPane.showMessageDialog(null, "nhân viên đã có", "cc", JOptionPane.WARNING_MESSAGE);

            } else {
                Nhanvien nv = new Nhanvien(tennv, diachinv, sdtnv, chucvunv, luongnv, gioitinhnv, anhnv);
                Element nhanvienn = doc.getDocumentElement();
                themnhanvien(doc, nhanvienn, nv);

                ghiFile();
                hienthi();
                clear();
            }
        }
    }

    public void xoa_nhan_vien() {
        try {
            String tennv, diachinv, sdtnv, chucvunv, luongnv, gioitinhnv, anhnv;
            int hangChon = bangnhanvien.getSelectedRow();
            tennv = ten.getText();
            diachinv = diachi.getText();
            sdtnv = sdt.getText();
            chucvunv = chucvu.getText();
            luongnv = luong.getText();
            gioitinhnv = gioitinh.getText();

            if (dayduthongtin(tennv, diachinv, sdtnv, chucvunv, luongnv, gioitinhnv)) {
                int n = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    NodeList nl = doc.getElementsByTagName("nhanvienn");
                    Node nodeToDelete = null;
                    for (int i = 0; i < nl.getLength(); i++) {
                        Element element = (Element) nl.item(i);
                        String tenNV = element.getElementsByTagName("ten").item(0).getTextContent();
                        String diachiNV = element.getElementsByTagName("diachi").item(0).getTextContent();
                        String sdtNV = element.getElementsByTagName("sodienthoai").item(0).getTextContent();
                        String chucvuNV = element.getElementsByTagName("chucvu").item(0).getTextContent();
                        String luongNV = element.getElementsByTagName("luong").item(0).getTextContent();
                        String gioitinhNV = element.getElementsByTagName("gioitinh").item(0).getTextContent();

                        if (tenNV.equalsIgnoreCase(tennv) && diachiNV.equalsIgnoreCase(diachinv) && sdtNV.equalsIgnoreCase(sdtnv)
                                && chucvuNV.equalsIgnoreCase(chucvunv) && luongNV.equalsIgnoreCase(luongnv) && gioitinhNV.equalsIgnoreCase(gioitinhnv)) {
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

    public void Sua_Nhan_Vien() {

        int hangChon = bangnhanvien.getSelectedRow();

        String tennv, diachinv, sdtnv, chucvunv, luongnv, gioitinhnv, anhnv;
        
        tennv = ten.getText();
        diachinv = diachi.getText();
        sdtnv = sdt.getText();
        chucvunv = chucvu.getText();
        luongnv = luong.getText();
        gioitinhnv = gioitinh.getText();
        anhnv = lay_tu_jlb(anhnhanvien);
      
        NodeList nl = doc.getElementsByTagName("nhanvienn");
        Element spE = (Element) nl.item(hangChon);
        spE.getElementsByTagName("ten").item(0).setTextContent(tennv);
        spE.getElementsByTagName("diachi").item(0).setTextContent(diachinv);
        spE.getElementsByTagName("sodienthoai").item(0).setTextContent(sdtnv);
        spE.getElementsByTagName("chucvu").item(0).setTextContent(chucvunv);
        spE.getElementsByTagName("luong").item(0).setTextContent(luongnv);
        spE.getElementsByTagName("gioitinh").item(0).setTextContent(gioitinhnv);
        spE.getElementsByTagName("anh").item(0).setTextContent(anhnv);
        ghiFile();
        hienthi();

        clear();
    }

    public void them_anh() {
        String anhnv = chonanh();
        if (anhnv != null) {
            anhnhanvien.setIcon(new ImageIcon(anhnv));
            int hangChon = bangnhanvien.getSelectedRow();

            String tennv, diachinv, sdtnv, chucvunv, luongnv, gioitinhnv;
            tennv = ten.getText();
            diachinv = diachi.getText();
            sdtnv = sdt.getText();
            chucvunv = chucvu.getText();
            luongnv = luong.getText();

            capNhatAnhNhanVien(tennv, diachinv, sdtnv, chucvunv, luongnv, anhnv);

            ghiFile();
        }
    }

    private boolean dayduthongtin(String ten, String diachi, String sdt, String chucvu, String luong, String gioitinh) {
        return true;
    }

    private boolean datrungnhanvien(String ten, String diachi, String sdt, String chucvu, String luong, String gioitinh) {
//        for (Nhanvien nv : list) {
//            if () {
//                return true;
//            }
//        }
        return false;
    }

    private void clear() {
        ten.setText("");
        diachi.setText("");
        sdt.setText("");
        chucvu.setText("");
        luong.setText("");
        gioitinh.setText("");

    }

}
