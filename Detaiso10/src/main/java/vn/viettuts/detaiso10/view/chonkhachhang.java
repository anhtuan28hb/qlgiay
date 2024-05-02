
package vn.viettuts.detaiso10.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import vn.viettuts.detaiso10.entity.Customer;
import vn.viettuts.detaiso10.view.Khachhangview;


public class chonkhachhang extends javax.swing.JFrame {
    Document doc;
    ArrayList<Customer> listkh;
   
    public chonkhachhang() {
        initComponents();
        hienthi();
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
            dftm.addColumn("Giới tính");

            for (Customer customer : listkh) {
                Object[] row = {customer.getTenkh(), customer.getDiachi(), customer.getSdt(), customer.getGioitinh(), customer.getNgaymua()};
                dftm.addRow(row);
            }
            jtb_bang_khach_hang.setModel(dftm);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Khachhangview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_bang_khach_hang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtb_bang_khach_hang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên", "Địa chỉ", "Số điện thoại", "Giới tính"
            }
        ));
        jtb_bang_khach_hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_bang_khach_hangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_bang_khach_hang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


private String ten;
private String diachi;
private String sdt;
private String gt;



    public String getTen() {
        return ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getGt() {
        return gt;
    }



    private void jtb_bang_khach_hangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_bang_khach_hangMouseClicked
        // TODO add your handling code here:
        int row = jtb_bang_khach_hang.getSelectedRow();   
          if(row != -1){
       ten = (String) jtb_bang_khach_hang.getValueAt(row, 0);
       diachi = (String) jtb_bang_khach_hang.getValueAt(row, 1);
       sdt = (String) jtb_bang_khach_hang.getValueAt(row, 2);
       gt = (String) jtb_bang_khach_hang.getValueAt(row, 3);
          }
    }//GEN-LAST:event_jtb_bang_khach_hangMouseClicked

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_bang_khach_hang;
    // End of variables declaration//GEN-END:variables
}
