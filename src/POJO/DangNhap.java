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
public class DangNhap {
    private String tenDN, matKhau, quyen;

    public DangNhap() {
    }

    public DangNhap(String tenDN, String matKhau, String quyen) {
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.quyen = quyen;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }
    
}
