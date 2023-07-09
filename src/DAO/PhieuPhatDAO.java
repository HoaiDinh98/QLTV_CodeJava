/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ChiTietPhieuPhat;
import POJO.PhieuPhat;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 84328
 */
public class PhieuPhatDAO {
    public static ArrayList<PhieuPhat> DanhSachPhieuPhat() {
        ArrayList<PhieuPhat> ds = new ArrayList<PhieuPhat>();
        try {
            String sql = "select * from PhieuPhat";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                PhieuPhat pp = new PhieuPhat();
                pp.setMaPhieuPhat(resultSet.getString("MaPhieuPhat"));
                pp.setMaPhieuTra(resultSet.getString("MaPhieuTra"));
                pp.setMaDocGia(resultSet.getString("MaDG"));
                pp.setMaNV(resultSet.getString("MaNV"));
                pp.setNgayLap(resultSet.getDate("NgayLapPhieu"));
                ds.add(pp);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
        public static ArrayList<PhieuPhat> DanhSachPhieuPhatSearch(String str) {
         ArrayList<PhieuPhat> ds = new ArrayList<PhieuPhat>();
        try {
            String sql = "SELECT * FROM PhieuPhat WHERE MaPhieuPhat like N'%"+str+"%' or MaNV like N'%"+str+"%'or MaPhieuTra like N'%"+str+"%' or MaDG like N'%"+str+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                 PhieuPhat pp = new PhieuPhat();
                pp.setMaPhieuPhat(resultSet.getString("maphieuphat"));
                pp.setMaPhieuTra(resultSet.getString("maphieutra"));
                pp.setMaDocGia(resultSet.getString("madg"));
                pp.setMaNV(resultSet.getString("manv"));
                pp.setNgayLap(resultSet.getDate("ngaylapphieu"));
                ds.add(pp);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    
    public static ArrayList<String> layDSMaPhieuTra() {
        ArrayList<String> ds = new ArrayList<String>();
        try {
            String sql = "select * from PhieuTra";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                ds.add(resultSet.getString("MaPhieuTra"));
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    
    
    public static boolean themPhieuPhat(ChiTietPhieuPhat ctpp, String maNV) {
        boolean kq = false;
        String sqlInsertChiTietPhieuPhat = "INSERT INTO ChiTietPhieuPhat VALUES(N'"+ctpp.getMaPhieuPhat()+"',N'"+ctpp.getMaPhieuTra()+"',N'"+ctpp.getMaLyDo()+"',N'"+ctpp.getLyDo()+"',"+ctpp.getSoLuong()+","
                + ""+ctpp.getSoTienPhat()+","+ctpp.getTongTienPhat()+",N'"+ctpp.getMaDocGia()+"',N'"+ctpp.getTenDocGia()+"',N'"+ctpp.getMaTaiLieu()+"',N'"+ctpp.getTenTaiLieu()+"','"+ctpp.getNgayLap()+"');";
        String sqlInsertPhieuPhat = "INSERT INTO PhieuPhat VALUES(N'"+ctpp.getMaPhieuPhat()+"',N'"+ctpp.getMaPhieuTra()+"',N'"+ctpp.getMaDocGia()+"',N'"+maNV+"','"+ctpp.getNgayLap()+"');";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sqlInsertPhieuPhat);
        if (n == 1) {
            kq = true;
            int m = provider.executeUpdate(sqlInsertChiTietPhieuPhat);
            if (m != 1) {
                kq = false;
                provider.executeUpdate("delete from PhieuPhat where MaPhieuPhat='"+ctpp.getMaPhieuPhat()+"'");
            }
        }
        provider.close();
        return kq;
    }
    
    public static boolean xoaPhieuPhat(String ma) {
        
        boolean kq = false;
        String sqlDeletePhieuTra = "delete from PhieuPhat where MaPhieuPhat='"+ma+"'";
        String sqlDeleteChiTietPhieuTra = "delete from ChiTietPhieuPhat where MaPhieuPhat='"+ma+"'";
        
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sqlDeleteChiTietPhieuTra);
        if (n == 1) {
            kq = true;
            provider.executeUpdate(sqlDeletePhieuTra); 
        }
        provider.close();
        return kq;
    }
    
    public static boolean suaPhieuPhat(ChiTietPhieuPhat ctpp, String maNV)
    {
        boolean kq = false;
        String sqlUpdateChiTietPhieuPhat = "update CHITIETPhieuPhat set maphieutra='"+ctpp.getMaPhieuTra()+"',MaLyDo=N'"+ctpp.getMaLyDo()+"',  lydo='"+ctpp.getLyDo()+"', soluong='"+ctpp.getSoLuong()+"', sotienphat='"+ctpp.getSoTienPhat()+"',Tongtienphat='"+ctpp.getTongTienPhat()+"', "
        + "madocgia='"+ctpp.getMaDocGia()+"', tendocgia='"+ctpp.getTenDocGia()+"', matailieu='"+ctpp.getMaTaiLieu()+"', tentailieu='"+ctpp.getTenTaiLieu()+"', ngaylapphieu='"+ctpp.getNgayLap()+"' where maPhieuPhat = '"+ctpp.getMaPhieuPhat()+"'";
        String sqlUpdatePhieuPhat = "update PhieuPhat set maphieutra='"+ctpp.getMaPhieuTra()+"', madocgia='"+ctpp.getMaDocGia()+"', manv='"+maNV+"', ngaylapphieu='"+ctpp.getNgayLap()+"' where maPhieuPhat = '"+ctpp.getMaPhieuPhat()+"'";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sqlUpdateChiTietPhieuPhat);
        if (n == 1) {
            kq = true;
            provider.executeUpdate(sqlUpdatePhieuPhat);
        }
        provider.close();
        return kq;
    }
    
}
