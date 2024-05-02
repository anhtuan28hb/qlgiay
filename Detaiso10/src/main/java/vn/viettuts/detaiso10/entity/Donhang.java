/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.viettuts.detaiso10.entity;

/**
 *
 * @author Bui Anh Tuan
 */
public class Donhang {
    private String tengiay;
    private double  soluong, doanhthu;

    public Donhang(String tengiay, double soluong, double doanhthu) {
        this.tengiay = tengiay;
        this.soluong = soluong;
        this.doanhthu = doanhthu;
    }

    public String getTengiay() {
        return tengiay;
    }

    public void setTengiay(String tengiay) {
        this.tengiay = tengiay;
    }

    public double getSoluong() {
        return soluong;
    }

    public void setSoluong(double soluong) {
        this.soluong = soluong;
    }

    public double getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(double doanhthu) {
        this.doanhthu = doanhthu;
    }
    
    
}
