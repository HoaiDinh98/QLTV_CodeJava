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
public class PhieuPhat {
    String maPhieuPhat, maPhieuTra, maDocGia ,maNV;
    Date ngayLap;

    public PhieuPhat() {
    }

    public PhieuPhat(String maPhieuPhat, String maPhieuTra, String maDocGia, String maNV, Date ngayLap) {
        this.maPhieuPhat = maPhieuPhat;
        this.maPhieuTra = maPhieuTra;
        this.maDocGia = maDocGia;
        this.maNV = maNV;
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

}
