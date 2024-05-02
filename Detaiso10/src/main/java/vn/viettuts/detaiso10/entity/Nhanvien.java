package vn.viettuts.detaiso10.entity;

public class Nhanvien {
    private String ten, diachi, sdt, chucvu, luong, gioitinh, anh;

    public Nhanvien() {
    }

    public Nhanvien(String ten, String diachi, String sdt, String chucvu, String luong, String gioitinh, String anh) {
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.chucvu = chucvu;
        this.luong = luong;
        this.gioitinh = gioitinh;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
}
