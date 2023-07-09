/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ChiTietPhieuTra;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author dell
 */
public class ChiTietPhieuTraDAO {
    public static ChiTietPhieuTra LoadChiTietPhieuTra(String maPhieu) {
        ChiTietPhieuTra ct = new ChiTietPhieuTra();
        try {
            String sql = "select * from CHITIETPHIEUTRA where MaPhieuTra = '" + maPhieu + "'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                ct.setMaPhieuTra(resultSet.getString("MaPhieuTra"));
                ct.setMaPhieuMuon(resultSet.getString("MaPhieuMuon"));
                ct.setMaDocGia(resultSet.getString("MaDocGia"));
                ct.setTenDocGia(resultSet.getString("TenDocGia"));
                ct.setMaTaiLieu(resultSet.getString("MaTaiLieu"));
                ct.setTenTaiLieu(resultSet.getString("TenTaiLieu"));
                ct.setSoLuongTra(Integer.valueOf(resultSet.getString("SoLuongTra")));
                ct.setNgayTra(Date.valueOf(resultSet.getString("NgayTra")));
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ct;
    }
     public static boolean checkMaPT(String ma) {
        String sql = "select * from CHITIETPHIEUTRA where MaPhieuTra = '"+ ma +"'";
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
         public static int LoadSoLuongTra(String ma) {
        int sl = -1;
        try {
            String sql = "select * from CHITIETPHIEUTRA where MaPhieuTra = '"+ma+"'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                sl = resultSet.getInt("SoLuongTra");
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sl;
    }
}
