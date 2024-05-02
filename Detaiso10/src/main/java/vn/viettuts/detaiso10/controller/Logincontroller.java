package vn.viettuts.detaiso10.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vn.viettuts.detaiso10.dao.Userdao;
import vn.viettuts.detaiso10.entity.User;
import vn.viettuts.detaiso10.view.Loginview;
import vn.viettuts.detaiso10.view.Shopview;

public class Logincontroller {

    private Userdao userdao;
    private Loginview loginview;
    private Shopview shopview;

    public Logincontroller(Loginview loginview) {
        this.loginview = loginview;
        this.userdao = new Userdao();
        loginview.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        loginview.setVisible(true);
    }

    /**
     * Lớp LoginListener chứa cài đặt cho sự kiện click button "Login"
     *
     * @author viettuts.vn
     */
    public class LoginListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            User user = loginview.getUser();
            if (userdao.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                shopview = new Shopview();
                Shopcontroller shopcontroller = new Shopcontroller(shopview);
                shopcontroller.showShopview();
                loginview.setVisible(false);
            }
        }
    }
}
