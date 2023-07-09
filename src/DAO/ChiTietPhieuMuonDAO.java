/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import POJO.ChiTietPhieuMuon;
import POJO.PhieuMuon;
import java.sql.Date;
import java.sql.ResultSet;
/**
 *
 * @author dell
 */
public class ChiTietPhieuMuonDAO {
    public static ChiTietPhieuMuon LoadChiTietPhieuMuon(String maPhieu) {
        ChiTietPhieuMuon ct = new ChiTietPhieuMuon();
        try {
            String sql = "select * from CHITIETPHIEUMUON where MaPhieuMuon = '" + maPhieu + "'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                ct.setMaPhieuMuon(resultSet.getString("MaPhieuMuon"));
                ct.setMaDocGia(resultSet.getString("MaDocGia"));
                ct.setTenDocGia(resultSet.getString("TenDocGia"));
                ct.setMaTaiLieu(resultSet.getString("MaTaiLieu"));
                ct.setTenTaiLieu(resultSet.getString("TenTaiLieu"));
                ct.setSoLuongMuon(Integer.valueOf(resultSet.getString("SoLuongMuon")));
                ct.setNgayMuon(Date.valueOf(resultSet.getString("NgayMuon")));
                ct.setHanTra(Date.valueOf(resultSet.getString("HanTra")));
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ct;
    }
    public static int LoadSoLuongMuon(String ma) {
        int sl = -1;
        try {
            String sql = "select * from CHITIETPHIEUMUON where MaPhieuMuon = '"+ma+"'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                sl = resultSet.getInt("soluongmuon");
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sl;
    }
//     public static int LoadSoLuongMuonKhiXoa(String ma) {
//        int sl = -1;
//        try {
//            String sql = "select * from CHITIETPHIEUMUON where MaPhieuMuon = '"+ma+"'";
//            SQLServerDataProvider provider = new SQLServerDataProvider();
//            provider.open();
//            ResultSet resultSet = provider.executeQuery(sql);
//            while(resultSet.next()) {
//                sl = resultSet.getInt("soluongmuon");
//            }
//            provider.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return sl;
//    }
    public static boolean checkMaPM(String ma) {
        String sql = "select * from CHITIETPHIEUMUON where MaPhieuMuon = '"+ ma +"'";
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
