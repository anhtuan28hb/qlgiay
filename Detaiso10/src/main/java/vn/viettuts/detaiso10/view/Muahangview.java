package vn.viettuts.detaiso10.view;

import XML.DonhangXML;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import vn.viettuts.detaiso10.entity.Customer;
import vn.viettuts.detaiso10.entity.Shoes;

public class Muahangview extends javax.swing.JPanel {

    org.w3c.dom.Document doc;
    com.itextpdf.text.Document pdfDocument = new com.itextpdf.text.Document();
    
    Document newDoc;
    ArrayList<Shoes> listsp;
    ArrayList<Customer> listkh;
    ArrayList<String> listtenkh;
    laydulieutudonhangxml n = new laydulieutudonhangxml();
    int Size = 38;

    public Muahangview() {
        initComponents();
        listsp = new ArrayList<>();
        hienthisp();
        hienthikh();
        panelsanpham.setLayout(new GridLayout(0, 2, 5, 5));
        hoadon();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hiensanpham = new javax.swing.JScrollPane();
        panelsanpham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hoa_don = new javax.swing.JTextArea();
        cbx_khachhang = new javax.swing.JComboBox<>();
        khachtratextfield = new javax.swing.JTextField();
        jbt_thanhtoan = new Buttonborder.MyButton();
        jbt_reset = new Buttonborder.MyButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(135, 206, 250));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsanpham.setBackground(new java.awt.Color(204, 255, 255));
        panelsanpham.setAutoscrolls(true);
        panelsanpham.setPreferredSize(new java.awt.Dimension(500, 6000));

        javax.swing.GroupLayout panelsanphamLayout = new javax.swing.GroupLayout(panelsanpham);
        panelsanpham.setLayout(panelsanphamLayout);
        panelsanphamLayout.setHorizontalGroup(
            panelsanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelsanphamLayout.setVerticalGroup(
            panelsanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6000, Short.MAX_VALUE)
        );

        hiensanpham.setViewportView(panelsanpham);

        add(hiensanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 500, 600));

        hoa_don.setColumns(20);
        hoa_don.setRows(5);
        jScrollPane1.setViewportView(hoa_don);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 370, 410));

        cbx_khachhang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_khachhang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_khachhangItemStateChanged(evt);
            }
        });
        cbx_khachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_khachhangActionPerformed(evt);
            }
        });
        add(cbx_khachhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 170, -1));

        khachtratextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khachtratextfieldActionPerformed(evt);
            }
        });
        add(khachtratextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 120, 20));

        jbt_thanhtoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_payments_black_24dp.png"))); // NOI18N
        jbt_thanhtoan.setText("Pay");
        jbt_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_thanhtoanActionPerformed(evt);
            }
        });
        add(jbt_thanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 120, 50));

        jbt_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_refresh_black_24dp.png"))); // NOI18N
        jbt_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_resetActionPerformed(evt);
            }
        });
        add(jbt_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 90, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Khách trả:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 100, 20));
    }// </editor-fold>//GEN-END:initComponents

    private Customer khachhang;

    public void capnhatkhachhang() {
        int vitri = cbx_khachhang.getSelectedIndex();
        if (vitri >= 0) {
            khachhang = listkh.get(vitri);
        }

    }
    private void cbx_khachhangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_khachhangItemStateChanged

    }//GEN-LAST:event_cbx_khachhangItemStateChanged

    private void khachtratextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khachtratextfieldActionPerformed
    }//GEN-LAST:event_khachtratextfieldActionPerformed

    private void jbt_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_thanhtoanActionPerformed
        // TODO add your handling code here:
        if (hoa_don.getText().contains("Hóa đơn mua hàng")) {
            JOptionPane.showMessageDialog(this, "Hãy thêm thông tin sản phẩm và khách hàng!", "Chú ý", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!khachtratextfield.getText().equals("")) {
                khachtra = Double.valueOf(khachtratextfield.getText());
                if (khachtra - tong >= 0) {
                    try {
                        hoa_don.print();
                    } 
                    catch (PrinterException ex) {
                        Logger.getLogger(Muahangview.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "Chưa đủ tiền", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Khách chưa trả tiền", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
        jbt_resetActionPerformed(evt);

    }//GEN-LAST:event_jbt_thanhtoanActionPerformed

    private void jbt_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_resetActionPerformed
        // TODO add your handling code here:
        hoadon();
        hoaDonMap.clear();
        khachtratextfield.setText("");
        tong = 0;
        khachhang = null;
    }//GEN-LAST:event_jbt_resetActionPerformed

    private void cbx_khachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_khachhangActionPerformed

        if (listkh != null) {
            int vitri = cbx_khachhang.getSelectedIndex();
            if (vitri >= 0) {
                khachhang = listkh.get(vitri);
                String hienTai = hoa_don.getText();
                int viTriBatDau = hienTai.lastIndexOf("-------------------------------------------------------------------------------------------------------------------------------------------");
                if (viTriBatDau != -1) {
                    hienTai = hienTai.substring(0, viTriBatDau);
                }
                int viTriCuoi = hienTai.lastIndexOf("Name Customer :");
                if (viTriCuoi != -1) {
                    String hienTaiMoi = hienTai.substring(0, viTriCuoi);
                    hoa_don.setText(hienTaiMoi + hienkhachhang());
                } else {
                    String hienTaiMoi = hienTai.replaceAll("-------------------------------------------------------------------------------------------------------------------------------------------------", "");
                    hoa_don.setText(hienTaiMoi + hienkhachhang());
                }
            }
        }


    }//GEN-LAST:event_cbx_khachhangActionPerformed

    public String hienkhachhang() {

        if (khachhang != null) {
            String thongtin = "";
            thongtin += "-------------------------------------------------------------------------------------------------------------------------------------------\n";
            thongtin += "Name Customer : " + khachhang.getTenkh() + "\n";
            thongtin += "Address: " + khachhang.getDiachi() + "\n";
            thongtin += "Phone number: " + khachhang.getSdt() + "\n";
            thongtin += "----------------------------------------------------------------------------------------------------------------------------------------\n";
            thongtin += "Total: " + tong + "\tVND" + "\n";
            return thongtin;
        } else {
            return "";
        }
    }
    int sl;
    private void hienthisp() {

        try {
            File xmlFile = new File("sanpham.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nlsanpham = doc.getElementsByTagName("sanpham");
            listsp = new ArrayList<>();
            listtenkh = new ArrayList<>();

            for (int i = 0; i < nlsanpham.getLength(); i++) {
                Element element = (Element) nlsanpham.item(i);
                String ten = element.getElementsByTagName("ten").item(0).getTextContent();
                String mau = element.getElementsByTagName("mau").item(0).getTextContent();
                String sizesp = element.getElementsByTagName("size").item(0).getTextContent();
                int gia = Integer.parseInt(element.getElementsByTagName("gia").item(0).getTextContent());
                String anhsp = element.getElementsByTagName("anh").item(0).getTextContent();
                listsp.add(new Shoes(ten, mau, sizesp, gia, anhsp));

                JPanel Item = taoItem(ten, sizesp, gia, anhsp);
                panelsanpham.add(Item);
                listsp.add(new Shoes(ten, mau, sizesp, gia, anhsp));
                sl++;
            }

            panelsanpham.revalidate();
            panelsanpham.repaint();

        } catch (ParserConfigurationException | org.xml.sax.SAXException | java.io.IOException ex) {
            java.util.logging.Logger.getLogger(Muahangview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hienthikh() {
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
                listtenkh.add(ten);
            }
            String[] tenkhachhang = listtenkh.toArray(new String[0]);
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(tenkhachhang);
            cbx_khachhang.setModel(model);
            panelsanpham.revalidate();
            panelsanpham.repaint();

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Muahangview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ghiFile(Document doc) {
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");

            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "donhang.xml";

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            tf.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DonhangXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DonhangXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int soluong = 0;

    public JPanel taoItem(String tensp, String sizesp, int giasp, String pic) {

        JPanel Item = new JPanel();
        JPanel anh_sp = new JPanel();
        JLabel ten_sp = new JLabel();
        JLabel size_sp = new JLabel();
        JLabel gia_sp = new JLabel();
        JTextField txt_ten = new JTextField();
        JTextField txt_gia = new JTextField();
        JComboBox cbx_size = new JComboBox<>();
        JButton them = new JButton();
        JButton xoa = new JButton();
        
        ten_sp.setText("Tên:");
        gia_sp.setText("Giá:");
        size_sp.setText("Size");
        them.setText("+");
        xoa.setText("-");
        txt_gia.setText(String.valueOf(giasp));
        txt_ten.setText(tensp);
        cbx_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"38", "39", "40", "41", "42","43", "44"}));
        ImageIcon icon = new ImageIcon(pic);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
        ImageIcon newicon = new ImageIcon(newimg);
        JLabel picicon = new JLabel(newicon);
        anh_sp.setBounds(5, 165, 50, 50);
        anh_sp.add(picicon);

        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                themSanPham(tensp, giasp, Size);

            }
        });
        capNhatHoaDonTextArea();
        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaSanPham(tensp, Size, giasp);
            }
        });
        cbx_size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Size = Integer.parseInt(cbx_size.getSelectedItem().toString());
            }
        });
        GroupLayout itemLayout = new javax.swing.GroupLayout(Item);
        Item.setLayout(itemLayout);
        itemLayout.setHorizontalGroup(
                itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(itemLayout.createSequentialGroup()
                                .addGroup(itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(itemLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(anh_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(itemLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(size_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbx_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(itemLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(itemLayout.createSequentialGroup()
                                                                .addComponent(ten_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE) // Sửa đổi: sử dụng ten_sp thay vì txt_ten
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(itemLayout.createSequentialGroup()
                                                                .addComponent(gia_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(them, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
        );
        itemLayout.setVerticalGroup(
                itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(itemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(anh_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ten_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE) // Sửa đổi: sử dụng ten_sp thay vì txt_ten
                                        .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbx_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(size_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(gia_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(them, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        
        panelsanpham.setPreferredSize(new Dimension(500,sl*190));
        panelsanpham.add(Item);

        return Item;
    }

    long thanhtoan = 0;
    double du = 0;
    double khachtra = 0;

    public void hoadon() {
        hoa_don.setText("\n\n\n                                       Hóa đơn mua hàng  \n");
    }
    HashMap<String, Integer[]> hoaDonMap = new HashMap<>();
    int tong;

    public void capNhatHoaDonTextArea() {
        tong = 0;
        hoa_don.setText("\n" + "\n" + "                     ---------------------Store TP---------------------\n" + "\n" + "\n"
                + "-------------------------------------------------------------------------------------------------------------------------------------------------\n"
                + "Shoes name                            " + "Size              " + "Stocks       " + "     Prices     \n"
        );
        for (Map.Entry<String, Integer[]> entry : hoaDonMap.entrySet()) {
            String key = entry.getKey();
            Integer[] info = entry.getValue();
            String[] parts = key.split("\t");
            String tenSP = parts[0];
            int sizeSP = Integer.parseInt(parts[1]);
            int soLuong = info[0];
            int gia = info[1];
            tong += gia * soLuong;

            hoa_don.append("\n" + tenSP + "                 " + sizeSP + "                 " + soLuong + "                 " + gia + "         " + "\n");
        }
        hienkhachhang();
        hoa_don.append("-----------------------------------------------------------------------------------------------------------------------------------------------------\n");
        hoa_don.append("Total: " + tong + "\tVND" + "\n");
        cbx_khachhangActionPerformed(null);

    }

    public void themSanPham(String tensp, int giasp, int sizesp) {
        String key = tensp + "\t" + sizesp;
        if (!hoaDonMap.containsKey(key)) {
            hoaDonMap.put(key, new Integer[]{1, giasp});
        } else {
            boolean sizeDaCo = false;
            for (String existingKey : hoaDonMap.keySet()) {
                String[] parts = existingKey.split("\t");
                String existingTenSP = parts[0];
                int existingSizeSP = Integer.parseInt(parts[1]);
                if (existingTenSP.equals(tensp) && existingSizeSP == sizesp) {
                    Integer[] info = hoaDonMap.get(existingKey);
                    int soLuongHienTai = info[0];
                    int giaHienTai = info[1];
                    soLuongHienTai++;
                    hoaDonMap.put(existingKey, new Integer[]{soLuongHienTai, giaHienTai});
                    sizeDaCo = true;
                    break;
                }
            }
            if (!sizeDaCo) {
                hoaDonMap.put(key, new Integer[]{1, giasp});
            }
        }
        capNhatHoaDonTextArea();
    }

    public void xoaSanPham(String tensp, int sizesp, int giasp) {
        String key = tensp + "\t" + sizesp;
        Integer[] info = hoaDonMap.get(key);
        if (info != null) {
            int soLuongHienTai = info[0];
            int giaHienTai = info[1];
            if (soLuongHienTai > 1) {

                soLuongHienTai--;
                hoaDonMap.put(key, new Integer[]{soLuongHienTai, giaHienTai});
            } else {
                hoaDonMap.remove(key);
            }
            capNhatHoaDonTextArea();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Không có sản phẩm trong hóa đơn");
        }
    }

    private void themdonhang(Document newDoc, Customer kh, HashMap<String, Integer[]> hoadon) {

        Element dh = newDoc.getDocumentElement();
        Element donhang = newDoc.createElement("donhangg");

        Element tenkh = newDoc.createElement("tenkh");
        tenkh.setTextContent(kh.getTenkh());
        Element diachi = newDoc.createElement("diachi");
        diachi.setTextContent(kh.getDiachi());
        Element sdt = newDoc.createElement("sodienthoai");
        sdt.setTextContent(kh.getSdt());

        for (Map.Entry<String, Integer[]> entry : hoadon.entrySet()) {
            String key = entry.getKey();
            Integer[] info = entry.getValue();
            String[] parts = key.split("\t");

            Element sanpham = newDoc.createElement("sanpham");
            Element tensp = newDoc.createElement("ten");
            tensp.setTextContent(parts[0]);

            Element size = newDoc.createElement("size");
            size.setTextContent(parts[1]);

            Element soluong = newDoc.createElement("soluong");
            soluong.setTextContent(String.valueOf(info[0]));

            Element gia = newDoc.createElement("gia");
            gia.setTextContent(String.valueOf(info[1]));

            sanpham.appendChild(tensp);
            sanpham.appendChild(size);
            sanpham.appendChild(soluong);
            sanpham.appendChild(gia);
            donhang.appendChild(sanpham);
        }
        donhang.appendChild(tenkh);
        donhang.appendChild(diachi);
        donhang.appendChild(sdt);

        dh.appendChild(donhang);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbx_khachhang;
    private javax.swing.JScrollPane hiensanpham;
    private javax.swing.JTextArea hoa_don;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Buttonborder.MyButton jbt_reset;
    private Buttonborder.MyButton jbt_thanhtoan;
    private javax.swing.JTextField khachtratextfield;
    private javax.swing.JPanel panelsanpham;
    // End of variables declaration//GEN-END:variables
}
