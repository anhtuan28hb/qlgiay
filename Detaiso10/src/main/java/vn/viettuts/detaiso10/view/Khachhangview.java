
package vn.viettuts.detaiso10.view;


import XML.khachhangXML;
import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
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

import vn.viettuts.detaiso10.controller.Khach_hang_controller;
import vn.viettuts.detaiso10.entity.Customer;

/**
 *
 * @author PC
 */
public final class Khachhangview extends javax.swing.JPanel {
    Document doc;
    ArrayList<Customer> listkh;
//    
    private final Khach_hang_controller controller;

    public Khachhangview() {
        initComponents();
        listkh = new ArrayList<>();
        controller = new Khach_hang_controller(doc, jtb_bang_khach_hang, txt_tenkh, txt_diachi, txt_sdt, txt_gioitinh, chon_ngay, listkh);
       controller.
               hienthi();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlb_tenkh = new javax.swing.JLabel();
        txt_tenkh = new javax.swing.JTextField();
        jlb_diachi = new javax.swing.JLabel();
        txt_diachi = new javax.swing.JTextField();
        jlb_sdt = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jlb_sdt1 = new javax.swing.JLabel();
        txt_gioitinh = new javax.swing.JTextField();
        chon_ngay = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bang_khach_hang = new javax.swing.JScrollPane();
        jtb_bang_khach_hang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jbt_them = new Buttonborder.MyButton();
        jbt_sua = new Buttonborder.MyButton();
        jbt_xoa = new Buttonborder.MyButton();
        clearbutton1 = new Buttonborder.MyButton();
        jbt_sort = new Buttonborder.MyButton();

        setBackground(new java.awt.Color(135, 206, 250));
        setPreferredSize(new java.awt.Dimension(900, 620));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/khachhang.png"))); // NOI18N
        jLabel2.setText("Khách hàng");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlb_tenkh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlb_tenkh.setForeground(new java.awt.Color(255, 255, 255));
        jlb_tenkh.setText("Thêm/sửa tên ");
        jPanel1.add(jlb_tenkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 20));
        jPanel1.add(txt_tenkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 330, -1));

        jlb_diachi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlb_diachi.setForeground(new java.awt.Color(255, 255, 255));
        jlb_diachi.setText("Thêm/sửa địa chỉ ");
        jPanel1.add(jlb_diachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));
        jPanel1.add(txt_diachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 330, -1));

        jlb_sdt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlb_sdt.setForeground(new java.awt.Color(255, 255, 255));
        jlb_sdt.setText("Thêm/sửa sđt");
        jPanel1.add(jlb_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 20));
        jPanel1.add(txt_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 330, -1));

        jlb_sdt1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlb_sdt1.setForeground(new java.awt.Color(255, 255, 255));
        jlb_sdt1.setText("Thêm/sửa giới tính");
        jPanel1.add(jlb_sdt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 125, 20));
        jPanel1.add(txt_gioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 110, -1));
        jPanel1.add(chon_ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 130, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ngày mua");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 68, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/AnasAbdin.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 170));

        jtb_bang_khach_hang.setBackground(new java.awt.Color(194, 255, 238));
        jtb_bang_khach_hang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên", "Địa chỉ", "Số điện thoại", "Giới tính", "Ngày mua"
            }
        ));
        jtb_bang_khach_hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_bang_khach_hangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtb_bang_khach_hangMouseEntered(evt);
            }
        });
        bang_khach_hang.setViewportView(jtb_bang_khach_hang);
        if (jtb_bang_khach_hang.getColumnModel().getColumnCount() > 0) {
            jtb_bang_khach_hang.getColumnModel().getColumn(0).setPreferredWidth(200);
            jtb_bang_khach_hang.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtb_bang_khach_hang.getColumnModel().getColumn(2).setPreferredWidth(200);
            jtb_bang_khach_hang.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtb_bang_khach_hang.getColumnModel().getColumn(4).setPreferredWidth(250);
        }

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logohvan.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/images_preview_rev_1.png"))); // NOI18N

        jbt_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_add_black_24dp.png"))); // NOI18N
        jbt_them.setText("Thêm");
        jbt_them.setRadius(25);
        jbt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_themActionPerformed(evt);
            }
        });

        jbt_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_edit_black_24dp.png"))); // NOI18N
        jbt_sua.setText("Sửa");
        jbt_sua.setRadius(25);
        jbt_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_suaActionPerformed(evt);
            }
        });

        jbt_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_delete_black_24dp.png"))); // NOI18N
        jbt_xoa.setText("Xóa");
        jbt_xoa.setRadius(25);
        jbt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_xoaActionPerformed(evt);
            }
        });

        clearbutton1.setText("Clear");
        clearbutton1.setRadius(25);
        clearbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbutton1ActionPerformed(evt);
            }
        });

        jbt_sort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_sort_black_24dp.png"))); // NOI18N
        jbt_sort.setRadius(21);
        jbt_sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_sortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bang_khach_hang)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbt_them, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clearbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbt_sort, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(228, 228, 228)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbt_them, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbt_sort, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(clearbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(bang_khach_hang, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_bang_khach_hangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_bang_khach_hangMouseEntered
      
    }//GEN-LAST:event_jtb_bang_khach_hangMouseEntered

    private void jtb_bang_khach_hangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_bang_khach_hangMouseClicked
                                                
       int row = jtb_bang_khach_hang.getSelectedRow();
       String ten, diachi, sdt, gt, nm;
       ten = (String) jtb_bang_khach_hang.getValueAt(row, 0);
       diachi = (String) jtb_bang_khach_hang.getValueAt(row, 1);
       sdt = (String) jtb_bang_khach_hang.getValueAt(row, 2);
       gt = (String) jtb_bang_khach_hang.getValueAt(row, 3);
       nm = (String) jtb_bang_khach_hang.getValueAt(row, 4);
       txt_tenkh.setText(ten);
       txt_diachi.setText(diachi);
       txt_sdt.setText(sdt);
       txt_gioitinh.setText(gt);
       SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
   try {
       Date selectedDate = sdf.parse(nm);
       chon_ngay.setDate(selectedDate);
   } catch (ParseException ex) {
       Logger.getLogger(Khachhangview.class.getName()).log(Level.SEVERE, null, ex);
   }
    }//GEN-LAST:event_jtb_bang_khach_hangMouseClicked

    private void jbt_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_themActionPerformed
        // TODO add your handling code here:
        controller.themKhachHang();
    }//GEN-LAST:event_jbt_themActionPerformed

    private void jbt_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_suaActionPerformed
        // TODO add your handling code here:
        controller.suaKhachHang();
    }//GEN-LAST:event_jbt_suaActionPerformed

    private void jbt_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_xoaActionPerformed
        // TODO add your handling code here:
        controller.xoaKhachHang();
    }//GEN-LAST:event_jbt_xoaActionPerformed

    private void clearbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbutton1ActionPerformed
        txt_tenkh.setText("");
        txt_sdt.setText("");
        txt_gioitinh.setText("");
        txt_diachi.setText("");
        chon_ngay.setDate(null);
    }//GEN-LAST:event_clearbutton1ActionPerformed

    private void jbt_sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_sortActionPerformed
        int columnCount = jtb_bang_khach_hang.getColumnCount();
        int[] columnWidths = new int[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnWidths[i] = jtb_bang_khach_hang.getColumnModel().getColumn(i).getWidth();
        }

        DefaultTableModel model = (DefaultTableModel) jtb_bang_khach_hang.getModel();

        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) jtb_bang_khach_hang.getRowSorter();
        if (sorter == null) {
            sorter = new TableRowSorter<>(model);
            jtb_bang_khach_hang.setRowSorter(sorter);
        }

        Comparator<Integer> priceComparator = Comparator.comparingInt(row -> Integer.parseInt(row.toString()));

        // Sắp xếp bảng
        sorter.sort();

        for (int i = 0; i < columnCount; i++) {
            jtb_bang_khach_hang.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
        }
    }//GEN-LAST:event_jbt_sortActionPerformed
 
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bang_khach_hang;
    private com.toedter.calendar.JDateChooser chon_ngay;
    private Buttonborder.MyButton clearbutton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private Buttonborder.MyButton jbt_sort;
    private Buttonborder.MyButton jbt_sua;
    private Buttonborder.MyButton jbt_them;
    private Buttonborder.MyButton jbt_xoa;
    private javax.swing.JLabel jlb_diachi;
    private javax.swing.JLabel jlb_sdt;
    private javax.swing.JLabel jlb_sdt1;
    private javax.swing.JLabel jlb_tenkh;
    private javax.swing.JTable jtb_bang_khach_hang;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_gioitinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenkh;
    // End of variables declaration//GEN-END:variables
}
