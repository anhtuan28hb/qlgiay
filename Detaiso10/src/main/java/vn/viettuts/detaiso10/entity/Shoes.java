package vn.viettuts.detaiso10.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sanpham")
@XmlAccessorType(XmlAccessType.FIELD)
public class Shoes implements Serializable{
    private static final long serialVersionUID = 1L;
    private String ten, mau, anh, size; 
    private int  gia;

    public Shoes() {
    }

    public Shoes(String ten, String mau, String size, int gia,String anh) {
        this.ten = ten;
        this.mau = mau;
        this.anh = anh;
        this.size = size;
        this.gia = gia;
    }

   

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

}
