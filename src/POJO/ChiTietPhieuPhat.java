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
public class ChiTietPhieuPhat {
    String maPhieuPhat, maPhieuTra, maDocGia, tenDocGia, maTaiLieu, tenTaiLieu, lyDo,maLyDo;

    public String getMaLyDo() {
        return maLyDo;
    }

    public void setMaLyDo(String maLyDo) {
        this.maLyDo = maLyDo;
    }
    int soLuong, soTienPhat,tongTienPhat;

    public int getTongTienPhat() {
        return tongTienPhat;
    }

    public void setTongTienPhat(int tongTienPhat) {
        this.tongTienPhat = tongTienPhat;
    }
    Date ngayLap;

    public ChiTietPhieuPhat() {
    }

    public ChiTietPhieuPhat(String maPhieuPhat, String maPhieuTra,String malydo, String maDocGia, String tenDocGia, String maTaiLieu, String tenTaiLieu, String lyDo, int soLuong, int soTienPhat,int tongtienphat, Date ngayLap) {
        this.maPhieuPhat = maPhieuPhat;
        this.maPhieuTra = maPhieuTra;
        this.maLyDo = malydo;
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.maTaiLieu = maTaiLieu;
        this.tenTaiLieu = tenTaiLieu;
        this.lyDo = lyDo;
        this.tongTienPhat = tongtienphat;
        this.soLuong = soLuong;
        this.soTienPhat = soTienPhat;
        this.ngayLap = ngayLap;
    }

    public String getMaPhieuPhat() {
        return maPhieuPhat;
    }

    public void setMaPhieuPhat(String maPhieuPhat) {
        this.maPhieuPhat = maPhieuPhat;
    }

    public String getMaPhieuTra() {
        return maPhieuTra;
    }

    public void setMaPhieuTra(String maPhieuTra) {
        this.maPhieuTra = maPhieuTra;
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

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoTienPhat() {
        return soTienPhat;
    }

    public void setSoTienPhat(int soTienPhat) {
        this.soTienPhat = soTienPhat;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }
    
}
