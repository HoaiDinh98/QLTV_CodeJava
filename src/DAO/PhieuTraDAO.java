/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ChiTietPhieuTra;
import POJO.PhieuTra;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 84328
 */
public class PhieuTraDAO {
    public static ArrayList<PhieuTra> DanhSachPhieuTra() {
        ArrayList<PhieuTra> ds = new ArrayList<PhieuTra>();
        try {
            String sql = "select * from PhieuTra";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                PhieuTra pt = new PhieuTra();
                pt.setMaPhieuTra(resultSet.getString("MaPhieuTra"));
                pt.setMaPhieuMuon(resultSet.getString("MaPhieuMuon"));
                pt.setMaDG(resultSet.getString("MaDocGia"));
                pt.setNgayLap(Date.valueOf(resultSet.getString("NgayLapPhieuTra")));
                pt.setMaNVLap(resultSet.getString("MaNV"));
                ds.add(pt);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    public static ArrayList<PhieuTra> DanhSachPhieuTraSearch(String str) {
         ArrayList<PhieuTra> ds = new ArrayList<PhieuTra>();
        try {
            String sql = "SELECT * FROM PhieuTra WHERE MaPhieuTra like N'%"+str+"%' or MaNV like N'%"+str+"%'or MaDocGia like N'%"+str+"%' or MaPhieuMuon like N'%"+str+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                PhieuTra pt = new PhieuTra();
                pt.setMaPhieuTra(resultSet.getString("MaPhieuTra"));
                pt.setMaPhieuMuon(resultSet.getString("MaPhieuMuon"));
                pt.setMaDG(resultSet.getString("MaDocGia"));
                pt.setNgayLap(Date.valueOf(resultSet.getString("NgayLapPhieuTra")));
                pt.setMaNVLap(resultSet.getString("MaNV"));
                ds.add(pt);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }

    
    
    
    public static boolean themPhieuTra(ChiTietPhieuTra ctpt, String maNV) {
        boolean kq = false;
           String sqlInsertPhieuTra = "INSERT INTO PhieuTra VALUES(N'"+ctpt.getMaPhieuTra()+"',N'"+ctpt.getMaPhieuMuon()+"',N'"+ctpt.getMaDocGia()+"','"+ctpt.getNgayTra()+"',N'"+maNV+"');";
        String sqlInsertChiTietPhieuTra = "INSERT INTO ChiTietPhieuTra VALUES(N'"+ctpt.getMaPhieuTra()+"',N'"+ctpt.getMaPhieuMuon()+"',N'"+ctpt.getMaDocGia()+"',"
                + "N'"+ctpt.getTenDocGia()+"',N'"+ctpt.getMaTaiLieu()+"',N'"+ctpt.getTenTaiLieu()+"',"+ctpt.getSoLuongTra()+",'"+ctpt.getNgayTra()+"');"; 
        String sqlUpdateTaiLieu = "update TaiLieu set ConLai=ConLai + '"+ctpt.getSoLuongTra()+"' where MaTaiLieu = '"+ctpt.getMaTaiLieu()+"'";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int y = provider.executeUpdate(sqlInsertPhieuTra);
        if (y != 1) {
            provider.close();
            return false;
        }
        int x = provider.executeUpdate(sqlUpdateTaiLieu);
        if (x == 1) {
            kq = true;
            provider.executeUpdate(sqlInsertChiTietPhieuTra);
        }
        else provider.executeUpdate("delete from PhieuTra where MaPhieuTra='"+ctpt.getMaPhieuTra()+"'");
        provider.close();
        return kq;
    }
    
    public static boolean xoaPhieuTra(String ma) {
        boolean kq = false;
        String sqlDeletePhieuTra = "delete from PhieuTra where MaPhieuTra='"+ma+"'";
        String sqlDeleteChiTietPhieuTra = "delete from CHITIETPHIEUTRA where MaPhieuTra='"+ma+"'";
        
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
    
    public static boolean suaPhieuTra(ChiTietPhieuTra ctpt, String maNV)
    {
        boolean kq = false;
        String sqlUpdateChiTietPhieuTra = "update CHITIETPhieuTra set maphieumuon='"+ctpt.getMaPhieuMuon()+"', madocgia='"+ctpt.getMaDocGia()+"', tendocgia='"+ctpt.getTenDocGia()+"', matailieu='"+ctpt.getMaTaiLieu()+"', "
                + "tentailieu='"+ctpt.getTenTaiLieu()+"', soluongtra='"+ctpt.getSoLuongTra()+"', ngaytra='"+ctpt.getNgayTra()+"' where maPhieuTra = '"+ctpt.getMaPhieuTra()+"'";
        String sqlUpdatePhieuTra = "update PhieuTra set maphieumuon='"+ctpt.getMaPhieuMuon()+"', madocgia='"+ctpt.getMaDocGia()+"', ngaylapphieutra='"+ctpt.getNgayTra()+"', manv='"+maNV+"' where maPhieuTra = '"+ctpt.getMaPhieuTra()+"'";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sqlUpdateChiTietPhieuTra);
        if (n == 1) {
            kq = true;
            provider.executeUpdate(sqlUpdatePhieuTra);
        }
        provider.close();
        return kq;
    }
    

    

}
