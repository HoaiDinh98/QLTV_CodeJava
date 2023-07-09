/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ChiTietPhieuMuon;
import POJO.TaiLieu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 84328
 */
public class TaiLieuDAO {
    public static ArrayList<TaiLieu> DanhSachTaiLieu() {
        ArrayList<TaiLieu> ds = new ArrayList<TaiLieu>();
        try {
            String sql = "select * from TaiLieu";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                TaiLieu tl = new TaiLieu();
                    tl.setMaTaiLieu(resultSet.getString("MaTaiLieu"));
                    tl.setTenTaiLieu(resultSet.getString("TenTaiLieu"));
                    tl.setTacGia(resultSet.getString("TacGia"));
                    tl.setSoLuong(resultSet.getInt("TongSo"));
                    tl.setConLai(resultSet.getInt("ConLai"));
                    tl.setGia(resultSet.getInt("Gia"));
                    tl.setAnh(resultSet.getString("Anh"));
                    ds.add(tl);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    
    public static ArrayList<TaiLieu> DanhSachTaiLieuSearch(String str) {
        ArrayList<TaiLieu> ds = new ArrayList<TaiLieu>();
        try {
            String sql = "SELECT * FROM TAILIEU WHERE   MaTaiLieu like N'%"+str+"%' or TacGia like N'%"+str+"%' or TenTaiLieu like N'%"+str+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                TaiLieu tl = new TaiLieu();
                    tl.setMaTaiLieu(resultSet.getString("MaTaiLieu"));
                    tl.setTenTaiLieu(resultSet.getString("TenTaiLieu"));
                    tl.setTacGia(resultSet.getString("TacGia"));
                    tl.setSoLuong(resultSet.getInt("TongSo"));
                    tl.setConLai(resultSet.getInt("ConLai"));
                    tl.setGia(resultSet.getInt("Gia"));
                    tl.setAnh(resultSet.getString("Anh"));
                    ds.add(tl);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    
    public static boolean themTaiLieu(TaiLieu tl) {
        boolean kq = false;
        String sql = "INSERT INTO TAILIEU VALUES(N'"+tl.getMaTaiLieu()+"',N'"+tl.getTenTaiLieu()+"',N'"+tl.getTacGia()+"',"+tl.getSoLuong()+","+tl.getConLai()+","+tl.getGia()+",N'"+tl.getAnh()+"')";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if (n == 1) kq = true;
        provider.close();
        return kq;
    }
    public static boolean checkMaTL(String ma) {
        String sql = "select * from TAILIEU where MaTaiLieu = '"+ ma +"'";
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
    
    public static TaiLieu LoadChiTietTaiLieu(String ma) {
        TaiLieu tl = new TaiLieu();
        try {
            String sql = "SELECT * FROM TAILIEU WHERE MaTaiLieu = '" + ma + "'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                    tl.setMaTaiLieu(resultSet.getString("MaTaiLieu"));
                    tl.setTenTaiLieu(resultSet.getString("TenTaiLieu"));
                    tl.setTacGia(resultSet.getString("TacGia"));
                    tl.setSoLuong(resultSet.getInt("TongSo"));
                    tl.setConLai(resultSet.getInt("ConLai"));
                    tl.setGia(resultSet.getInt("Gia"));
                    tl.setAnh(resultSet.getString("Anh"));
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tl;
    }
    public static String LoadTenTaiLieu(String ma) {
        String tenTaiLieu = "error";
        try {
            String sql = "select * from TaiLieu where matailieu = '"+ma+"'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                tenTaiLieu = resultSet.getString("TenTaiLieu");
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tenTaiLieu;
    }      
    public static boolean xoaTaiLieu(String ma) {
        boolean kq = false;
        String sql = String.format("Delete from TAILIEU where matailieu = ('%s');", ma);
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if (n == 1) kq = true;
        provider.close();
        return kq;
    }
    
    public static boolean suaTaiLieu(TaiLieu tl)
    {
        boolean kq = false;
        String sql = "update TAILIEU set tentailieu = '"+tl.getTenTaiLieu()+"', tacgia = '"+tl.getTacGia()+"', tongso = '"+tl.getSoLuong()+"', conlai = '"+tl.getConLai()+"', gia = '"+tl.getGia()+"', anh = '"+tl.getAnh()+"'  where matailieu = '"+tl.getMaTaiLieu()+"'";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if (n == 1) kq = true;
        provider.close();
        return kq;
    }
    

    
    public static int layGiaTaiLieu(String ma) {
        int gia = -1;
        try {
            String sql = "select * from TaiLieu where matailieu = '"+ma+"'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                gia = resultSet.getInt("Gia");
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return gia;
    }
    public static int laySoLuongConLai(String ma) {
        int sl = -1;
        try {
            String sql = "select * from TAILIEU where MaTaiLieu = '"+ma+"'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                sl = resultSet.getInt("ConLai");
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sl;
    }
        public static boolean laySoLuongConLaiKhiXoa(String slconlai,String matl) {
        boolean kq = false;
        String sqlUpdateTaiLieu = "update TaiLieu set ConLai=ConLai + '"+slconlai+"' where MaTaiLieu = '"+matl+"'";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int x = provider.executeUpdate(sqlUpdateTaiLieu);
        if (x == 1) {
            kq = true;
        }
        provider.close();
        return kq;
    }
}
