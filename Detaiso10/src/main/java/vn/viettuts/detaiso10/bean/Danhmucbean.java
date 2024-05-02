package vn.viettuts.detaiso10.bean;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Danhmucbean {

    private String kind;
    private JPanel jpanel;
    private JButton jbutton;

    public Danhmucbean() {

    }

    public Danhmucbean(String kind, JPanel jpanel, JButton jbutton) {
        this.kind = kind;
        this.jpanel = jpanel;
        this.jbutton = jbutton;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }

    public JButton getJbutton() {
        return jbutton;
    }

    public void setJbutton(JButton jbutton) {
        this.jbutton = jbutton;
    }


}
