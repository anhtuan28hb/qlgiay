package vn.viettuts.detaiso10.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import vn.viettuts.detaiso10.bean.Danhmucbean;
import vn.viettuts.detaiso10.view.Aboutview;
import vn.viettuts.detaiso10.view.Khachhangview;
import vn.viettuts.detaiso10.view.Muahangview;
import vn.viettuts.detaiso10.view.Sanphamview;
import vn.viettuts.detaiso10.view.Thongkeview;
import vn.viettuts.detaiso10.view.Helpview;
import vn.viettuts.detaiso10.view.Trangchuview;

public class Chuyenmanhinhcontroller {
    private String kind;
    private JPanel node;
    private JPanel jpanelItem;
    private JButton jbuttonItem;
    private final JPanel root;
    private String kindSelected = "";
    private List<Danhmucbean> listitem = null;

    public Chuyenmanhinhcontroller(JPanel jpanelroot) {
        this.root = jpanelroot;
    }

    public void setView(String kind) {
        switch (kind) {
                case "manhinhchinh" -> node = new Trangchuview();
                case "sanpham" -> node = new Sanphamview();
                case "khachhang" -> node = new Khachhangview();
                case "muahang" -> node = new Muahangview() ;
                case "thongke" -> node = new Thongkeview();
                case "about" -> node = new Aboutview();
                case "help" -> node = new Helpview();
                default -> {
                }
            }

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(node);
        root.validate();
        root.repaint();
    }

    public void setEvent(List<Danhmucbean> listitem) {
        this.listitem = listitem;
        for (Danhmucbean item : listitem) {
            item.getJbutton().addMouseListener(new ButtonEvent(item.getKind(), item.getJpanel(), item.getJbutton()));
        }
    }

    class ButtonEvent implements MouseListener {
        private JPanel node;
        private final String kind;
        private final JPanel jpanelItem;
        private final JButton jbuttonItem;

        public ButtonEvent(String kind, JPanel jpanelItem, JButton jbuttonItem) {
            this.kind = kind;
            this.jpanelItem = jpanelItem;
            this.jbuttonItem = jbuttonItem;
        }
        

        @Override
        public void mouseClicked(MouseEvent e) {
            setView(kind);
           
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    public void setChangeBackground(String kind) {
        for (Danhmucbean item : listitem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpanel().setBackground(new Color(96, 100, 191));
                item.getJbutton().setBackground(new Color(96, 100, 191));
            } else {
                item.getJpanel().setBackground(new Color(76, 175, 80));
                item.getJbutton().setBackground(new Color(76, 175, 80));
            }
        }
    }
}
