/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84328
 */
public class NhanVienDAO {
    public static ArrayList<NhanVien> DanhSachNhanVien() {
        ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
        try {
            String sql = "select * from NhanVien";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(resultSet.getString("MaNV"));
                nv.setHoTen(resultSet.getString("HoTen"));
                nv.setNgaySinh(resultSet.getDate("NgaySinh"));
                nv.setTenDN(resultSet.getString("TenDangNhap"));
                nv.setSdt(resultSet.getString("SoDienThoai"));
                nv.setLoaiNV(resultSet.getString("LoaiNV"));
                nv.setAnh(resultSet.getString("anh"));
                ds.add(nv);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    
    public static ArrayList<NhanVien> DanhSachNhanVienSearch(String str) {
        ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
        try {
            String sql = "SELECT * FROM NHANVIEN WHERE HoTen like N'%"+str+"%' or MaNV like N'%"+str+"%' or TenDangNhap like N'%"+str+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(resultSet.getString("MaNV"));
                nv.setHoTen(resultSet.getString("HoTen"));
                nv.setNgaySinh(resultSet.getDate("NgaySinh"));
                nv.setTenDN(resultSet.getString("TenDangNhap"));
                nv.setSdt(resultSet.getString("SoDienThoai"));
                nv.setLoaiNV(resultSet.getString("LoaiNV"));
                nv.setAnh(resultSet.getString("anh"));
                ds.add(nv);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    
    public static boolean themNhanVien(NhanVien nv) {
        boolean kq = false;
        String sqlInsertTaiKhoan = "INSERT INTO TAIKHOAN VALUES(N'"+nv.getTenDN()+"',N'111',N'"+nv.getLoaiNV()+"');";
        String sqlInsertNhanVien = "INSERT INTO NHANVIEN VALUES(N'"+nv.getMaNV()+"', N'"+nv.getSdt()+"',N'"+nv.getTenDN()+"',N'"+nv.getHoTen()+"',"
                + "'"+nv.getNgaySinh()+"',N'"+nv.getLoaiNV()+"',N'"+nv.getAnh()+"')";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int y = provider.executeUpdate(sqlInsertTaiKhoan);
        int x = provider.executeUpdate(sqlInsertNhanVien);
        if (x == 1) kq = true;
        provider.close();
        return kq;
    }
    
    public static boolean xoaNhanVien(NhanVien nv) {
        boolean kq = false;
        String sqlDeleteTK = "delete from taikhoan where tendangnhap='"+nv.getTenDN()+"'";
        String sqlDelete = "delete from nhanvien where manv='"+nv.getMaNV()+"'";
        
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sqlDelete);
        if (n == 1) {
            kq = true;
            provider.executeUpdate(sqlDeleteTK); 
        }
        provider.close();
        return kq;
    }
    
    public static boolean suaNhanVien(NhanVien nv)
    {
        boolean kq = false;
        String sqlUpdate = "update nhanvien set sodienthoai='"+nv.getSdt()+"', tendangnhap='"+nv.getTenDN()+"', hoten='"+nv.getHoTen()+"', "
                + "ngaysinh='"+nv.getNgaySinh()+"', loainv='"+nv.getLoaiNV()+"', anh = '"+nv.getAnh()+"' where manv = '"+nv.getMaNV()+"'";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sqlUpdate);
        if (n == 1) kq = true;
        provider.close();
        return kq;
    }
    
    public static boolean checkTenDN(String tenDN) {
        String sql = "select * from taikhoan where TenDangNhap = '"+ tenDN +"'";
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
    public static boolean checkMaNV(String ma) {
        String sql = "select * from nhanvien where manv = '"+ ma +"'";
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
    public static ArrayList<String> LoadLoaiNV() {
        ArrayList<String> ds_lnv = new ArrayList<String>();
        try {
            String sql = "select TenLoaiNV from LoaiNhanVien";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                ds_lnv.add(resultSet.getString("TenLoaiNV"));
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    
        return ds_lnv;
    }
    
}
