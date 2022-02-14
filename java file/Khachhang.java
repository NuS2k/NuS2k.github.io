/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplon_java;

/**
 *
 * @author THUY
 */
public abstract class Khachhang implements Ikhachhang {
    protected String maKH;
    protected String hoTen;
    protected int ngay, thang, nam;
    protected long soLuong;
    protected long donGia;

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }


    public long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(long soLuong) {
        this.soLuong = soLuong;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }
    
    public Khachhang(){
        maKH = "";
        hoTen = "";
        ngay = 1;
        thang = 1;
        nam = 1;
        soLuong = 0;
        donGia = 0;
    }

    public Khachhang(String maKH, String hoTen, int ngay, int thang, int nam, long soLuong, long donGia) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    
    
}
