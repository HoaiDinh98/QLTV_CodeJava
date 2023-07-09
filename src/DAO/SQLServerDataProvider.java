/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 84328
 */
public class SQLServerDataProvider {
    private Connection connection = null;
    public String connectionURL = null;
    
    public void open() {
        String strServer = "DESKTOP-1DHUUH7\\SQLEXPRESS";
        //String strServer = "KENTCFS\\KENTCFS";
        String strDatabase = "QLTV14";
        String strUser = "sa";
        String strPassword = "123";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connectionURL="jdbc:sqlserver://"+strServer
                    + ":1433;databaseName=" + strDatabase
                    + ";user="+strUser
                    + ";password="+strPassword;
            connection=DriverManager.getConnection(connectionURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void close() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public int executeUpdate(String sql) {
        int kq = -1;
        try {
            Statement statement = connection.createStatement();
            kq = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
    
    public String getConnectionURL() {
        return connectionURL;
    }
}
