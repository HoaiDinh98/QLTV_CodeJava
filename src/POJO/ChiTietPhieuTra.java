/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Date;

/**
 *
 * @author 84328
 */
public class ChiTietPhieuTra {
    String maPhieuTra, maPhieuMuon, maDocGia, tenDocGia, maTaiLieu, tenTaiLieu;
    int soLuongTra;
    Date ngayTra;

    public ChiTietPhieuTra() {
    }

    public ChiTietPhieuTra(String maPhieuTra, String maPhieuMuon, String maDocGia, String tenDocGia, String maTaiLieu, String tenTaiLieu, int soLuongTra, Date ngayTra) {
        this.maPhieuTra = maPhieuTra;
        this.maPhieuMuon = maPhieuMuon;
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.maTaiLieu = maTaiLieu;
        this.tenTaiLieu = tenTaiLieu;
        this.soLuongTra = soLuongTra;
        this.ngayTra = ngayTra;
    }

    public String getMaPhieuTra() {
        return maPhieuTra;
    }

    public void setMaPhieuTra(String maPhieuTra) {
        this.maPhieuTra = maPhieuTra;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
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

    public int getSoLuongTra() {
        return soLuongTra;
    }

    public void setSoLuongTra(int soLuongTra) {
        this.soLuongTra = soLuongTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
    
}
