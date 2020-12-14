package com.ss.basics.singleton;

import java.math.BigDecimal;
import java.sql.*;

public class SampleSingleton {
    private static Connection conn = null;
    private static SampleSingleton instance = null;

    private SampleSingleton(){}

    public static SampleSingleton getInstance(){
        if(instance == null)
            instance = new SampleSingleton();
        return instance;
    }
    public static void databaseQuery(BigDecimal input){
        try {
            conn = DriverManager.getConnection("url");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id from table");
            int x = 0;
            while (rs.next()) {
                x = rs.getInt(1) * input.intValue();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
