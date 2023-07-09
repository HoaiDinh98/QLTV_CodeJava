/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.DocGia;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 84328
 */
public class DocGiaDAO {
    public static ArrayList<DocGia> DanhSachDocGia() {
        ArrayList<DocGia> ds = new ArrayList<DocGia>();
        try {
            String sql = "select * from docgia";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                DocGia dg = new DocGia();
                dg.setMaDG(resultSet.getString("madocgia"));
                dg.setTenDG(resultSet.getString("hoten"));
                dg.setNgaySinh(resultSet.getDate("ngaysinh"));
                dg.setDiaChi(resultSet.getString("diachi"));
                dg.setMail(resultSet.getString("Email"));
                dg.setSdt(resultSet.getString("sdt"));
                ds.add(dg);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
    
    public static ArrayList<DocGia> DanhSachDocGiaSearch(String str) {
        ArrayList<DocGia> ds = new ArrayList<DocGia>();
        try {
            String sql = "SELECT * FROM DOCGIA WHERE HoTen like N'%"+str+"%' or MaDocGia like N'%"+str+"%' ";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                DocGia dg = new DocGia();
                dg.setMaDG(resultSet.getString("madocgia"));
                dg.setTenDG(resultSet.getString("hoten"));
                dg.setNgaySinh(resultSet.getDate("ngaysinh"));
                dg.setDiaChi(resultSet.getString("diachi"));
                dg.setMail(resultSet.getString("Email"));
                dg.setSdt(resultSet.getString("sdt"));
                ds.add(dg);
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
        public static String LoadTenDocGia(String ma) {
        String hoTenDG = "error";
        try {
            String sql = "select * from DOCGIA where MaDocGia = '"+ma+"'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                hoTenDG = resultSet.getString("hoten");
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hoTenDG;
    }
    
    public static boolean themDocGia(DocGia dg) {
        boolean kq = false;
        String sql = "INSERT INTO DocGia VALUES(N'"+dg.getMaDG()+"', N'"+dg.getTenDG()+"',N'"+dg.getNgaySinh()+"',N'"+dg.getDiaChi()+"',N'"+dg.getMail()+"',N'"+dg.getSdt()+"',0)";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if (n == 1) kq = true;
        provider.close();
        return kq;
    }
    public static boolean checkMadg(String maDG) {
        String sql = "select * from DocGia where MaDocGia = '"+ maDG +"'";
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
    public static boolean xoaDocGia(String ma) {
        boolean kq = false;
        String sql = String.format("Delete from docgia where madocgia = ('"+ma+"');");
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if (n == 1) kq = true;
        provider.close();
        return kq;
    }
    
    public static boolean suaDocGia(DocGia dg)
    {
        boolean kq = false;
        String sql = "update docgia set hoten='"+dg.getTenDG()+"', ngaysinh='"+dg.getNgaySinh()+"', diachi='"+dg.getDiaChi()+"', email='"+dg.getMail()+"', sdt='"+dg.getSdt()+"' where madocgia = '"+dg.getMaDG()+"'";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if (n == 1) kq = true;
        provider.close();
        return kq;
    }
    

}
