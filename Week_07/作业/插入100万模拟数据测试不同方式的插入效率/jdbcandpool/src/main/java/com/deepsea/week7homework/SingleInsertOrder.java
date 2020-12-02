package com.deepsea.week7homework;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SingleInsertOrder {

    public void doPreparedInsert(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/geekbang?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false", "root", "mysql123456");
            Long startTime = System.currentTimeMillis();
            for(int i=0; i<1000000; i++){
                PreparedStatement pstm = conn.prepareStatement("insert into sys_order(user_id, user_name, price, status, create_time, update_time) values(?,?,?,?,?,?)");
                pstm.setLong(1,i+1);
                pstm.setString(2,"单条"+i);
                pstm.setBigDecimal(3,new BigDecimal("10"));
                pstm.setInt(4,1);
                pstm.setLong(5,System.currentTimeMillis());
                pstm.setLong(6,System.currentTimeMillis());
                pstm.executeUpdate();
            }
            Long endTime = System.currentTimeMillis();
            System.out.println("插入100万条数据耗时："+ (endTime - startTime));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        /**
         * 单条插入耗时2464307毫秒=41分钟
         */
        SingleInsertOrder singleInsertOrder = new SingleInsertOrder();
        singleInsertOrder.doPreparedInsert();
    }
}
