/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class PhieuTra {
    String maPhieuTra, maPhieuMuon, maNVLap, maDG;
    Date ngayLap;

    public PhieuTra() {
    }

    public PhieuTra(String maPhieuTra, String maPhieuMuon, String maNVLap, String maDG, Date ngayLap) {
        this.maPhieuTra = maPhieuTra;
        this.maPhieuMuon = maPhieuMuon;
        this.maNVLap = maNVLap;
        this.maDG = maDG;
        this.ngayLap = ngayLap;
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

    public String getMaNVLap() {
        return maNVLap;
    }

    public void setMaNVLap(String maNVLap) {
        this.maNVLap = maNVLap;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

}
