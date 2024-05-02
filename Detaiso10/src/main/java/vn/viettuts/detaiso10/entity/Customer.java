package vn.viettuts.detaiso10.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {    
    private String tenkh, diachi, sdt, gioitinh, ngaymua; 
 
   
    private List<Muahang> DSDH;
    public Customer() {
    }

    public Customer(String tenkh, String diachi, String sdt, String gioitinh, String ngaymua) {
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.ngaymua = ngaymua;
    }
    

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

 
    
}
