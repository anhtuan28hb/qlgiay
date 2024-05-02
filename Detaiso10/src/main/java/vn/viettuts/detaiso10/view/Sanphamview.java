package vn.viettuts.detaiso10.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import vn.viettuts.detaiso10.controller.San_pham_controller;
import vn.viettuts.detaiso10.entity.Shoes;

public class Sanphamview extends javax.swing.JPanel {

    Document doc;
    ArrayList<Shoes> list;
    San_pham_controller controller;

    public Sanphamview() {

        initComponents();
        list = new ArrayList<>();
        controller = new San_pham_controller(doc, themsuanametextfield, themsuamautextfield, themsuasizetextfield, themsuagiatextfield, TOOL_TIP_TEXT_KEY, sanphamtable, picturelabel, list);
        controller.hienthi();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        sanphamtable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        themsuanamelabel = new javax.swing.JLabel();
        themsuanametextfield = new javax.swing.JTextField();
        themsuamaulabel = new javax.swing.JLabel();
        themsuamautextfield = new javax.swing.JTextField();
        themsuasizelable = new javax.swing.JLabel();
        themsuasizetextfield = new javax.swing.JTextField();
        themsuagialable = new javax.swing.JLabel();
        themsuagiatextfield = new javax.swing.JTextField();
        thembutton = new Buttonborder.MyButton();
        suabutton = new Buttonborder.MyButton();
        xoabutton = new Buttonborder.MyButton();
        sortbutton = new Buttonborder.MyButton();
        clearbutton = new Buttonborder.MyButton();
        themanhbutton = new Buttonborder.MyButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        picturelabel = new javax.swing.JLabel();
        timkiemcobobox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        timkiemtextfield = new javax.swing.JTextField();
        timkiemlabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 239, 213));
        setPreferredSize(new java.awt.Dimension(900, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sanphamtable.setBackground(new java.awt.Color(135, 206, 250));
        sanphamtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Màu", "Size", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sanphamtable.setColumnSelectionAllowed(true);
        sanphamtable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sanphamtable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sanphamtable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sanphamtable.getTableHeader().setReorderingAllowed(false);
        sanphamtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sanphamtableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(sanphamtable);
        sanphamtable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (sanphamtable.getColumnModel().getColumnCount() > 0) {
            sanphamtable.getColumnModel().getColumn(0).setResizable(false);
            sanphamtable.getColumnModel().getColumn(0).setPreferredWidth(240);
            sanphamtable.getColumnModel().getColumn(1).setResizable(false);
            sanphamtable.getColumnModel().getColumn(1).setPreferredWidth(90);
            sanphamtable.getColumnModel().getColumn(2).setResizable(false);
            sanphamtable.getColumnModel().getColumn(2).setPreferredWidth(10);
            sanphamtable.getColumnModel().getColumn(3).setResizable(false);
            sanphamtable.getColumnModel().getColumn(3).setPreferredWidth(90);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 500, 310));

        jPanel1.setBackground(new java.awt.Color(255, 239, 213));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        themsuanamelabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themsuanamelabel.setForeground(new java.awt.Color(255, 255, 255));
        themsuanamelabel.setText("Thêm/Sửa tên");
        jPanel1.add(themsuanamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 20));
        jPanel1.add(themsuanametextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 250, 20));

        themsuamaulabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themsuamaulabel.setForeground(new java.awt.Color(255, 255, 255));
        themsuamaulabel.setText("Thêm/Sửa màu");
        jPanel1.add(themsuamaulabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 20));
        jPanel1.add(themsuamautextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 250, -1));

        themsuasizelable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themsuasizelable.setForeground(new java.awt.Color(255, 255, 255));
        themsuasizelable.setText("Thêm/Sửa size");
        jPanel1.add(themsuasizelable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 90, 20));
        jPanel1.add(themsuasizetextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 250, -1));

        themsuagialable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themsuagialable.setForeground(new java.awt.Color(255, 255, 255));
        themsuagialable.setText("Thêm/Sửa giá");
        jPanel1.add(themsuagialable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 81, 20));
        jPanel1.add(themsuagiatextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 250, -1));

        thembutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_add_black_24dp.png"))); // NOI18N
        thembutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thembuttonActionPerformed(evt);
            }
        });
        jPanel1.add(thembutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 50));

        suabutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_edit_black_24dp.png"))); // NOI18N
        suabutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suabuttonActionPerformed(evt);
            }
        });
        jPanel1.add(suabutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 80, 50));

        xoabutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_delete_black_24dp.png"))); // NOI18N
        xoabutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoabuttonActionPerformed(evt);
            }
        });
        jPanel1.add(xoabutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 80, 50));

        sortbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_sort_black_24dp.png"))); // NOI18N
        sortbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(sortbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 80, 50));

        clearbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_refresh_black_24dp.png"))); // NOI18N
        clearbutton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(clearbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 120, 50));

        themanhbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/themanh.png"))); // NOI18N
        themanhbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themanhbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(themanhbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 120, 50));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abc123.jpg"))); // NOI18N
        jLabel17.setText("jLabel17");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 370));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 253, 370, 360));

        jPanel2.setBackground(new java.awt.Color(135, 206, 235));

        picturelabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        picturelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gifgit.gif"))); // NOI18N
        picturelabel.setPreferredSize(new java.awt.Dimension(497, 280));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(picturelabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(picturelabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 500, 280));

        timkiemcobobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên", "Size" }));
        timkiemcobobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemcoboboxActionPerformed(evt);
            }
        });
        add(timkiemcobobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 70, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logohvan.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        timkiemtextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemtextfieldActionPerformed(evt);
            }
        });
        add(timkiemtextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 250, -1));

        timkiemlabel.setBackground(new java.awt.Color(255, 255, 255));
        timkiemlabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        timkiemlabel.setForeground(new java.awt.Color(255, 255, 255));
        timkiemlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_search_white_24dp.png"))); // NOI18N
        timkiemlabel.setText("Tìm kiếm:");
        add(timkiemlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/images_preview_rev_1.png"))); // NOI18N
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 255));
        jLabel14.setText("Bước đi tự do");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 140, -1));

        jLabel15.setFont(new java.awt.Font("Vivaldi", 2, 37)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 0, 255));
        jLabel15.setText("Fashion-Quality-Comfortable");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 370, 29));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Free-Sky-with-Clouds-Background-Pixel-Art5.jpg"))); // NOI18N
        jLabel16.setText("jLabel16");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void sanphamtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sanphamtableMouseClicked
        int hangChon = sanphamtable.getSelectedRow();
        String tensp,  sizesp,mausp;
        int giasp;
        tensp = (String) sanphamtable.getValueAt(hangChon, 0);
        mausp = (String) sanphamtable.getValueAt(hangChon, 1);
        sizesp = (String) sanphamtable.getValueAt(hangChon, 2);
        giasp = (int) sanphamtable.getValueAt(hangChon, 3);

        themsuanametextfield.setText(tensp);
        themsuamautextfield.setText(mausp);
        themsuasizetextfield.setText(sizesp);
        themsuagiatextfield.setText(String.valueOf(giasp));

        String anh = controller.lay_anh(tensp, mausp, sizesp, giasp);
        controller.hien_anh(anh, picturelabel);
    }//GEN-LAST:event_sanphamtableMouseClicked

    private void timkiemcoboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemcoboboxActionPerformed

    }//GEN-LAST:event_timkiemcoboboxActionPerformed

    private void timkiemtextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemtextfieldActionPerformed
        DefaultTableModel tb = (DefaultTableModel) sanphamtable.getModel();
        TableRowSorter<DefaultTableModel> tbb = new TableRowSorter<>(tb);
        sanphamtable.setRowSorter(tbb);

        String searchText = timkiemtextfield.getText().trim();
        String searchBy = (String) timkiemcobobox.getSelectedItem();

        // Xác định loại tìm kiếm và áp dụng bộ lọc tương ứng
        switch (searchBy) {
            case "Tên":
                tbb.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 0)); // Tìm kiếm theo cột tên (cột 0)
                break;
            case "Size":
                tbb.setRowFilter(RowFilter.regexFilter(searchText, 2)); // Tìm kiếm theo cột size (cột 2)
                break;
            default:
                break;
        }

    }//GEN-LAST:event_timkiemtextfieldActionPerformed

    private void thembuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thembuttonActionPerformed
        // TODO add your handling code here:
        controller.them_san_pham();
    }//GEN-LAST:event_thembuttonActionPerformed

    private void suabuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suabuttonActionPerformed
        // TODO add your handling code here:
        controller.sua_san_pham();
    }//GEN-LAST:event_suabuttonActionPerformed

    private void sortbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortbuttonActionPerformed
        // TODO add your handling code here:
        // Lưu lại kích thước của các cột
        int columnCount = sanphamtable.getColumnCount();
        int[] columnWidths = new int[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnWidths[i] = sanphamtable.getColumnModel().getColumn(i).getWidth();
        }

        DefaultTableModel model = (DefaultTableModel) sanphamtable.getModel();

        // Tạo một TableRowSorter mới hoặc lấy TableRowSorter hiện tại
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) sanphamtable.getRowSorter();
        if (sorter == null) {
            sorter = new TableRowSorter<>(model);
            sanphamtable.setRowSorter(sorter);
        }

        // Thiết lập Comparator cho cột giá
        Comparator<Integer> priceComparator = Comparator.comparingInt(row -> Integer.parseInt(row.toString()));
        sorter.setComparator(3, priceComparator); // 3 là chỉ số của cột giá (chỉ số bắt đầu từ 0)

        // Sắp xếp bảng
        sorter.sort();

        // Khôi phục kích thước của các cột
        for (int i = 0; i < columnCount; i++) {
            sanphamtable.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
        }
    }//GEN-LAST:event_sortbuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        // TODO add your handling code here:
        themsuanametextfield.setText("");
        themsuamautextfield.setText("");
        themsuasizetextfield.setText("");
        themsuagiatextfield.setText("");
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void themanhbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themanhbuttonActionPerformed
        // TODO add your handling code here:
        controller.them_anh();
    }//GEN-LAST:event_themanhbuttonActionPerformed

    private void xoabuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoabuttonActionPerformed
        // TODO add your handling code here:
        controller.xoa_san_pham();
    }//GEN-LAST:event_xoabuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private Buttonborder.MyButton clearbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel picturelabel;
    private javax.swing.JTable sanphamtable;
    private Buttonborder.MyButton sortbutton;
    private Buttonborder.MyButton suabutton;
    private Buttonborder.MyButton themanhbutton;
    private Buttonborder.MyButton thembutton;
    private javax.swing.JLabel themsuagialable;
    private javax.swing.JTextField themsuagiatextfield;
    private javax.swing.JLabel themsuamaulabel;
    private javax.swing.JTextField themsuamautextfield;
    private javax.swing.JLabel themsuanamelabel;
    private javax.swing.JTextField themsuanametextfield;
    private javax.swing.JLabel themsuasizelable;
    private javax.swing.JTextField themsuasizetextfield;
    private javax.swing.JComboBox<String> timkiemcobobox;
    private javax.swing.JLabel timkiemlabel;
    private javax.swing.JTextField timkiemtextfield;
    private Buttonborder.MyButton xoabutton;
    // End of variables declaration//GEN-END:variables
}
