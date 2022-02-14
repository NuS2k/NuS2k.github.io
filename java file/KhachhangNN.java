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
public class KhachhangNN extends Khachhang{
    private String quocTich;

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public long getThanhTien() {
        return (soLuong*donGia);
    }

    public KhachhangNN(String quocTich, String maKH, String hoTen, int ngay, int thang, int nam, long soLuong, long donGia) {
        super(maKH, hoTen, ngay, thang, nam, soLuong, donGia);
        this.quocTich = quocTich;
    }

    
    
    
}
