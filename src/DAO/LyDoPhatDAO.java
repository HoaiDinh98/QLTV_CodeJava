/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.LyDoPhat;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class LyDoPhatDAO {
        public static LyDoPhat LoadChiTietLyDo(String malydo) {
        LyDoPhat ct = new LyDoPhat();
        try {
            String sql = "select * from LYDOPHAT where MaLyDo = '" + malydo + "'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                ct.setMaLyDo(resultSet.getString("MaLyDo"));
                ct.setLyDo(resultSet.getString("LyDo"));
                ct.setSoTienPhat(Integer.valueOf(resultSet.getString("SoTienPhat")));
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ct;
    }
        public static String LoadTenLyDo(String ma) {
        String tenTaiLieu = "error";
        try {
            String sql = "select * from LYDOPHAT where MaLyDo = '"+ma+"'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                tenTaiLieu = resultSet.getString("LyDo");
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tenTaiLieu;
    }
            public static ArrayList<String> LoadDanhSachMaPhieuMuon() {
        ArrayList<String> ds = new ArrayList<String>();
        try {
            String sql = "select * from LYDOPHAT";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while(resultSet.next()) {
                ds.add(resultSet.getString("MaLyDo"));
            }
            provider.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ds;
    }
}
