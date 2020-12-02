package com.deepsea.week7homework;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class BatchInsertOrder {

    public void doBatchPreparedInsert(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/geekbang?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false", "root", "mysql123456");
            conn.setAutoCommit(false);
            Long startTime = System.currentTimeMillis();
            System.out.println("开始时间："+new Date());
            int flag = 1;
            PreparedStatement pstm = conn.prepareStatement("insert into sys_order(user_id, user_name, price, status, create_time, update_time) values(?,?,?,?,?,?)");
            for(int i=0; i<1000000; i++){
                flag ++;
                pstm.setLong(1,i+1);
                pstm.setString(2,"批量"+i);
                pstm.setBigDecimal(3,new BigDecimal("20"));
                pstm.setInt(4,1);
                pstm.setLong(5,System.currentTimeMillis());
                pstm.setLong(6,System.currentTimeMillis());
                pstm.addBatch();
                if(flag == 200){
                    pstm.executeBatch();
                    conn.commit();
                    flag = 1;
                }

            }
            Long endTime = System.currentTimeMillis();
            System.out.println("结束时间:"+new Date());
            System.out.println("插入100万条数据耗时："+ ((endTime - startTime)/1000));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /**
         * 以200条为一组批量插入数据，耗时77秒
         */
        BatchInsertOrder batchInsertOrder = new BatchInsertOrder();
        batchInsertOrder.doBatchPreparedInsert();
    }
}
