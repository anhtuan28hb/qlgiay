package vn.viettuts.detaiso10.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vn.viettuts.detaiso10.App;

import vn.viettuts.detaiso10.controller.Logincontroller;
import vn.viettuts.detaiso10.entity.User;

public class Loginview extends javax.swing.JFrame {

    public Loginview() {
        initComponents();
        getRootPane().setDefaultButton(loginbutton);
        hidelabel.setVisible(false);
        // Lấy kích thước của màn hình
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Lấy kích thước của cửa sổ
        Dimension windowSize = this.getSize();

        // Tính toán vị trí mới để đặt cửa sổ ở giữa màn hình
        int x = (screenSize.width - windowSize.width) / 2;
        int y = (screenSize.height - windowSize.height) / 2;
        this.setLocation(x, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        anh1label = new javax.swing.JLabel();
        welcomelabel = new javax.swing.JLabel();
        namestorelabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        loginlabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        passwordlabel = new javax.swing.JLabel();
        usernametextfield = new javax.swing.JTextField();
        loginbutton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        passwordfield = new javax.swing.JPasswordField();
        showlabel = new javax.swing.JLabel();
        hidelabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");

        jPanel3.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(0, 191, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 500));

        anh1label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Remove-bg.ai_1711792579411.png"))); // NOI18N

        welcomelabel.setFont(new java.awt.Font(".VnSouthernH", 1, 24)); // NOI18N
        welcomelabel.setForeground(new java.awt.Color(255, 255, 224));
        welcomelabel.setText("welcome to");

        namestorelabel.setFont(new java.awt.Font(".VnSouthernH", 1, 40)); // NOI18N
        namestorelabel.setForeground(new java.awt.Color(255, 255, 224));
        namestorelabel.setText("the TP store");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/images_preview_rev_1.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logohvan.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(namestorelabel)
                        .addContainerGap(50, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(welcomelabel)
                .addGap(112, 112, 112))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(anh1label, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(anh1label, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(welcomelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namestorelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jLabel1 = new javax.swing.JLabel();
        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/logohvan.png");
        Image image = imageIcon.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image);
        jLabel1.setIcon(imageIcon);

        jLabel1.setToolTipText("");

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 400, 500);

        jPanel1.setBackground(new java.awt.Color(232, 241, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        loginlabel.setBackground(new java.awt.Color(255, 255, 224));
        loginlabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        loginlabel.setForeground(new java.awt.Color(0, 191, 255));
        loginlabel.setText("Đăng nhập");

        usernamelabel.setBackground(new java.awt.Color(255, 255, 224));
        usernamelabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        usernamelabel.setForeground(new java.awt.Color(0, 191, 255));
        usernamelabel.setText("Email:");

        passwordlabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        passwordlabel.setForeground(new java.awt.Color(0, 191, 255));
        passwordlabel.setText("Mật Khẩu:");

        usernametextfield.setBackground(new java.awt.Color(232, 241, 255));
        usernametextfield.setBorder(null);
        usernametextfield.setPreferredSize(new java.awt.Dimension(370, 40));
        usernametextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernametextfieldActionPerformed(evt);
            }
        });

        loginbutton.setBackground(new java.awt.Color(0, 191, 255));
        loginbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginbutton.setForeground(new java.awt.Color(255, 255, 255));
        loginbutton.setText("Xác nhận");
        loginbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(232, 241, 255));

        passwordfield.setBackground(new java.awt.Color(232, 241, 255));
        passwordfield.setBorder(null);

        showlabel.setBackground(new java.awt.Color(0, 191, 255));
        showlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_visibility_black_24dp.png"))); // NOI18N
        showlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showlabelMousePressed(evt);
            }
        });

        hidelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abcd.png"))); // NOI18N
        hidelabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hidelabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hidelabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showlabel)
                    .addComponent(hidelabel)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(showlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(hidelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jSeparator1.setBackground(new java.awt.Color(255, 255, 224));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 224));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 191, 255), 7));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 224));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 224));
        jSeparator2.setToolTipText("");
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 191, 255), 7));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginlabel)
                    .addComponent(usernamelabel)
                    .addComponent(passwordlabel)
                    .addComponent(usernametextfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginbutton)
                .addGap(139, 139, 139))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(loginlabel)
                .addGap(18, 18, 18)
                .addComponent(usernamelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernametextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(passwordlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(loginbutton)
                .addGap(64, 64, 64))
        );

        jPanel3.add(jPanel1);
        jPanel1.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordtextfieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
//GEN-FIRST:event_passworldtextfieldActionPerformed
        char[] password = passwordfield.getPassword();
        String passwordstring = new String(password);
        
        if (passwordstring.equals("b10d54attt")) {
            passwordfield.setText(passwordstring);
        } else {
            JOptionPane.showMessageDialog(this, "Mật khẩu sai !!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            passwordfield.setText("");
            passwordfield.requestFocus();
        }                                                  
    }//GEN-LAST:event_passworldtextfieldActionPerformed

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        // TODO add your handling code here:
        if(this.isVisible()){
            
            String username = usernametextfield.getText();
            char[] charpassword=passwordfield.getPassword();
            String password = new String(charpassword);
            if (username.equals("@admindetai10") && password.equals("b10d54attt")) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                Shopview shopview = new Shopview();
                shopview.setVisible(true);
            } 
            else if(username.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu sai!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                usernametextfield.setText("");
                passwordfield.setText("");
                usernametextfield.requestFocus();
            }
        }
        

    }//GEN-LAST:event_loginbuttonActionPerformed

    private void usernametextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernametextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametextfieldActionPerformed

    private void showlabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showlabelMousePressed
        // TODO add your handling code here:
        hidelabel.setVisible(true);
        showlabel.setVisible(false);
        passwordfield.setEchoChar((char) 0);
    }//GEN-LAST:event_showlabelMousePressed

    private void hidelabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidelabelMousePressed
        // TODO add your handling code here:
        showlabel.setVisible(true);
        hidelabel.setVisible(false);
        passwordfield.setEchoChar('\u2022');
    }//GEN-LAST:event_hidelabelMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anh1label;
    private javax.swing.JLabel hidelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loginbutton;
    private javax.swing.JLabel loginlabel;
    private javax.swing.JLabel namestorelabel;
    private javax.swing.JPasswordField passwordfield;
    private javax.swing.JLabel passwordlabel;
    private javax.swing.JLabel showlabel;
    private javax.swing.JLabel usernamelabel;
    private javax.swing.JTextField usernametextfield;
    private javax.swing.JLabel welcomelabel;
    // End of variables declaration//GEN-END:variables

    public User getUser() {
        return new User(usernametextfield.getText(),
                String.copyValueOf(passwordfield.getPassword()));
    }

    public void addLoginListener(Logincontroller.LoginListener loginListener) {
        loginbutton.addActionListener(loginListener);

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void actionPerformed(ActionEvent e) {
    }

}
