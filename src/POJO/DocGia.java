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
public class DocGia {
   String maDG, tenDG, diaChi, mail, sdt;
   Date ngaySinh;

    public DocGia() {
    }

    public DocGia(String maDG, String tenDG, String diaChi, String mail, String sdt, Date ngaySinh) {
        this.maDG = maDG;
        this.tenDG = tenDG;
        this.diaChi = diaChi;
        this.mail = mail;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getTenDG() {
        return tenDG;
    }

    public void setTenDG(String tenDG) {
        this.tenDG = tenDG;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

  

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    
}
