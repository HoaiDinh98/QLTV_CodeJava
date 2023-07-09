/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author 84328
 */
public class TaiLieu {
    String maTaiLieu, tenTaiLieu, tacGia, anh;
    int soLuong, conLai, gia;

    public TaiLieu() {
    }

    public TaiLieu(String maTaiLieu, String tenTaiLieu, String tacGia, int soLuong, int conLai, int gia, String anh) {
        this.maTaiLieu = maTaiLieu;
        this.tenTaiLieu = tenTaiLieu;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.conLai = conLai;
        this.gia = gia;
         this.anh = anh;
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getTenTaiLieu() {
        return tenTaiLieu;
    }

    public void setTenTaiLieu(String tenTaiLieu) {
        this.tenTaiLieu = tenTaiLieu;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getConLai() {
        return conLai;
    }

    public void setConLai(int conLai) {
        this.conLai = conLai;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int giaBan) {
        this.gia = giaBan;
    }
    
    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
