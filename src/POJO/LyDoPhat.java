/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author dell
 */
public class LyDoPhat {
    String maLyDo,lyDo;
    int soTienPhat;

    public LyDoPhat(){
        
    }
    public LyDoPhat(String maLyDo, String lyDo,int soTienPhat){
        this.maLyDo = maLyDo;
        this.lyDo = lyDo;
        this.soTienPhat = soTienPhat;
    }
    public String getMaLyDo() {
        return maLyDo;
    }

    public void setMaLyDo(String maLyDo) {
        this.maLyDo = maLyDo;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public int getSoTienPhat() {
        return soTienPhat;
    }

    public void setSoTienPhat(int soTienPhat) {
        this.soTienPhat = soTienPhat;
    }
}
