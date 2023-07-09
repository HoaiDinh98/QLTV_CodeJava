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
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class PhieuMuonDAO {
    public static ArrayList<PhieuMuon> DanhSachPhieuMuon() {
        ArrayList<PhieuMuon> ds = new ArrayList<PhieuMuon>();
        try {
            String sql = "select * from PhieuMuon";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMaPhieuMuon(resultSet.getString("MaPhieuMuon"));
                pm.setMaNVLap(resultSet.getString("MaNV"));
                pm.setMaDG(resultSet.getString("MaDocGia"));
                pm.setTinhTrang(resultSet.getString("TinhTrang"));
                pm.setNgayLap(Date.valueOf(resultSet.getString("NgayLapPhieuMuon")));
                ds.add(pm);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    
    public static ArrayList<PhieuMuon> DanhSachPhieuMuonSearch(String str) {
         ArrayList<PhieuMuon> ds = new ArrayList<PhieuMuon>();
        try {
            String sql = "SELECT * FROM PhieuMuon WHERE MaPhieuMuon like N'%"+str+"%' or MaNV like N'%"+str+"%' or MaDocGia like N'%"+str+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMaPhieuMuon(resultSet.getString("MaPhieuMuon"));
                pm.setMaNVLap(resultSet.getString("MaNV"));
                pm.setMaDG(resultSet.getString("MaDocGia"));
                pm.setTinhTrang(resultSet.getString("TinhTrang"));
                pm.setNgayLap(Date.valueOf(resultSet.getString("NgayLapPhieuMuon")));
                ds.add(pm);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    public static boolean checkMaPM(String ma) {
        String sql = "select * from PhieuMuon where MaPhieuMuon = '"+ ma +"'";
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
    public static ArrayList<String> LoadDanhSachMaPhieuMuon() {
        ArrayList<String> ds = new ArrayList<String>();
        try {
            String sql = "select * from PhieuMuon";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                ds.add(resultSet.getString("MaPhieuMuon"));
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    
    public static boolean themPhieuMuon(ChiTietPhieuMuon ctpm, String maNV) {
        boolean kq = false;
        String sqlInsertChiTietPhieuMuon = "INSERT INTO CHITIETPHIEUMUON VALUES(N'"+ctpm.getMaPhieuMuon()+"',N'"+ctpm.getMaDocGia()+"',"
                + "N'"+ctpm.getTenDocGia()+"',N'"+ctpm.getMaTaiLieu()+"',N'"+ctpm.getTenTaiLieu()+"',"+ctpm.getSoLuongMuon()+",'"+ctpm.getNgayMuon()+"','"+ctpm.getHanTra()+"');";
        String sqlInsertPhieuMuon = "INSERT INTO PHIEUMUON VALUES(N'"+ctpm.getMaPhieuMuon()+"',N'"+maNV+"',N'"+ctpm.getMaDocGia()+"',N'Đang Mượn','"+ctpm.getNgayMuon()+"');";
        String sqlUpdateTaiLieu = "update TaiLieu set ConLai=ConLai - '"+ctpm.getSoLuongMuon()+"' where MaTaiLieu = '"+ctpm.getMaTaiLieu()+"'";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int y = provider.executeUpdate(sqlInsertPhieuMuon);
        if (y != 1) {
            provider.close();
            return false;
        }
        int x = provider.executeUpdate(sqlInsertChiTietPhieuMuon);
        if (x == 1) {
            kq = true;
            provider.executeUpdate(sqlUpdateTaiLieu);
        }
        else provider.executeUpdate("delete from PHIEUMUON where MaPhieuMuon='"+ctpm.getMaPhieuMuon()+"'");
        provider.close();
        return kq;
    }
    
    public static boolean xoaPhieuMuon(String ma) {
        boolean kq = false;
        String sqlDeletePhieuMuon = "delete from PHIEUMUON where MaPhieuMuon='"+ma+"'";
        String sqlDeleteChiTietPhieuMuon = "delete from CHITIETPHIEUMUON where MaPhieuMuon='"+ma+"'";
        
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sqlDeleteChiTietPhieuMuon);
        if (n == 1) {
            kq = true;
            provider.executeUpdate(sqlDeletePhieuMuon); 
        }
        provider.close();
        return kq;
    }
    
    public static boolean suaPhieuMuon(ChiTietPhieuMuon ctpm, String maNV) {
        boolean kq = false;
        int temp = ctpm.getSoLuongMuon();
        String sqlUpdateChiTietPhieuMuon = "update CHITIETPHIEUMUON set madocgia=N'"+ctpm.getMaDocGia()+"', tendocgia=N'"+ctpm.getTenDocGia()+"', matailieu=N'"+ctpm.getMaTaiLieu()+"', "
                + "tentailieu=N'"+ctpm.getTenTaiLieu()+"', soluongmuon='"+ctpm.getSoLuongMuon()+"', ngaymuon='"+ctpm.getNgayMuon()+"', hantra='"+ctpm.getHanTra()+"' where maphieumuon = '"+ctpm.getMaPhieuMuon()+"'";
        String sqlUpdatePhieuMuon = "update PHIEUMUON set manv=N'"+maNV+"', madocgia=N'"+ctpm.getMaDocGia()+"', tinhtrang=N'Đang Mượn', ngaylapphieumuon='"+ctpm.getNgayMuon()+"' where maphieumuon = '"+ctpm.getMaPhieuMuon()+"'";
        String sqlUpdateTaiLieuBanDau = "update TaiLieu set ConLai=ConLai + '"+ctpm.getSoLuongMuon()+"' where MaTaiLieu = '"+ctpm.getMaTaiLieu()+"'";
        
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sqlUpdateChiTietPhieuMuon);
        if (n == 1) {
            kq = true;
            provider.executeUpdate(sqlUpdatePhieuMuon);
        }
        provider.close();
        return kq;
    }
        public static boolean capNhatTrangThaiPhieuMuon(String ma, int trangThai)
    {  
        boolean kq = false;
        String tinhTrang = null;
        if(trangThai == 0)  
            tinhTrang = "Đã Trả";
        else tinhTrang = "Còn Mượn";
        String sqlUpdatePhieuMuon = "update PhieuMuon set TinhTrang = N'"+tinhTrang+"' where maPhieuMuon = '"+ma+"'";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sqlUpdatePhieuMuon);
        if (n == 1) kq = true;
        provider.close();
        return kq;
    }
    public static String getConnectionURL() {
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        return provider.getConnectionURL();
    }

}
