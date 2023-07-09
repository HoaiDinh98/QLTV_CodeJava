/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ChiTietPhieuPhat;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author dell
 */
public class ChiTietPhieuPhatDAO {
     public static ChiTietPhieuPhat LoadChiTietPhieuPhat(String maPhieu) {
        ChiTietPhieuPhat ct = new ChiTietPhieuPhat();
        try {
            String sql = "select * from CHITIETPHIEUPHAT where MaPhieuPhat = '" + maPhieu + "'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                ct.setMaPhieuPhat(resultSet.getString("MaPhieuPhat"));
                ct.setMaPhieuTra(resultSet.getString("MaPhieuTra"));
                 ct.setMaLyDo(resultSet.getString("MaLyDo"));
                ct.setLyDo(resultSet.getString("LyDo"));
                ct.setSoLuong(Integer.valueOf(resultSet.getString("SoLuong")));
                ct.setSoTienPhat(Integer.valueOf(resultSet.getString("SoTienPhat")));
                ct.setTongTienPhat(Integer.valueOf(resultSet.getString("TongTienPhat")));
                ct.setMaDocGia(resultSet.getString("MaDocGia"));
                ct.setTenDocGia(resultSet.getString("TenDocGia"));
                ct.setMaTaiLieu(resultSet.getString("MaTaiLieu"));
                ct.setTenTaiLieu(resultSet.getString("TenTaiLieu"));
                ct.setNgayLap(Date.valueOf(resultSet.getString("NgayLapPhieu")));
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ct;
    }
        public static boolean checkMaPP(String ma) {
        String sql = "select * from CHITIETPHIEUPHAT where MaPhieuPhat = '"+ ma +"'";
        try {
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            if (resultSet.next())
                return false;
            else return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
        return true;
    }
     
}
