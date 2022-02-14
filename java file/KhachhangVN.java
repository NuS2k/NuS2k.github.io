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
public class KhachhangVN extends Khachhang{
    private int doituong;
    private long dinhmuc;

    public int getDoituong() {
        return doituong;
    }

    public void setDoituong(int doituong) {
        this.doituong = doituong;
    }

    public long getDinhmuc() {
        return dinhmuc;
    }

    public void setDinhmuc(long dinhmuc) {
        this.dinhmuc = dinhmuc;
    }
    
    @Override
    public long getThanhTien() {
        if (soLuong > dinhmuc ) return (long) (soLuong * donGia * dinhmuc + (soLuong - dinhmuc)*donGia*2.5);
        else return( soLuong*donGia); 
    }

    public KhachhangVN(int doituong, long dinhmuc, String maKH, String hoTen, int ngay, int thang, int nam, long soLuong, long donGia) {
        super(maKH, hoTen, ngay, thang, nam, soLuong, donGia);
        this.doituong = doituong;
        this.dinhmuc = dinhmuc;
    }

   
    
}
