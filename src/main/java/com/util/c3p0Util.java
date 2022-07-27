package com.util;

import java.beans.PropertyVetoException;
import java.sql.*;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class c3p0Util {
    
    
    public static DataSource dataSource = getDS();

    private static DataSource getDS(){
        //ComboPooledDataSource ds = new ComboPooledDataSource("mysql");
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl("jdbc:mysql://42.193.118.157:3306/tcm?characterEncoding=utf-8");
        ds.setUser("root");
        ds.setPassword("zzzyyyhhh");
        ds.setInitialPoolSize(10);
        ds.setMinPoolSize(5);
        ds.setMaxPoolSize(100);
        ds.setMaxIdleTime(30);
        ds.setAcquireIncrement(5);
        ds.setDebugUnreturnedConnectionStackTraces(false);//无法读到配置文件,不知原因
        return ds;
    }
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    public static int closeAll(Connection conn, Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
    public static int closeAll(Connection conn, PreparedStatement prst){
        try {
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
    public static int update(String sql, Object... params){
        PreparedStatement prst = null;
        Connection conn = null;
        Integer res = 0;
        try {
            conn = getConnection();
            prst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++){
                prst.setObject(i+1, params[i]);
            }
            res = prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c3p0Util.closeAll(conn, prst);
        return res;
    }
}