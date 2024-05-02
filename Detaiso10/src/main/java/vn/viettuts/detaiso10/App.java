package vn.viettuts.detaiso10;
import XML.DonhangXML;
import XML.SanphamXML;
import XML.khachhangXML;
import vn.viettuts.detaiso10.controller.Logincontroller;
import vn.viettuts.detaiso10.view.Loginview;
import vn.viettuts.detaiso10.view.Shopview;
import vn.viettuts.detaiso10.view.laydulieutudonhangxml;
public class App {
    public static void main(String args[]) {
//        Shopview n = new Shopview();
//        Loginview m = new Loginview();
        SanphamXML.taosanphamxml();
        khachhangXML.taokhachhangxml();
        DonhangXML.taoDonHangxml();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Loginview view= new Loginview();
                Logincontroller controller = new Logincontroller(view);
                controller.showLoginView();
            }
        });
    }
}