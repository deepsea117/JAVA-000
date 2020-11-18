package com.deepsea.jdbc;

import java.sql.*;

public class JdbcInsert {

    public void doInsert(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/energylot", "postgres", "postgresql");
            Statement stm = conn.createStatement();
            String sql = "insert into sys_user(user_id, user_name, status) values('geek2','极客2', '1')";
            int result = stm.executeUpdate(sql);
            System.out.println(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPreparedInsert(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/energylot", "postgres", "postgresql");
            PreparedStatement pstm = conn.prepareStatement("insert into sys_user(user_id, user_name, status) values(?,?,?)");
            pstm.setString(1,"geek3");
            pstm.setString(2,"极客3");
            pstm.setString(3,"1");
            int result = pstm.executeUpdate();
            System.out.println(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        JdbcInsert jdbcInsert = new JdbcInsert();
        jdbcInsert.doInsert();
        jdbcInsert.doPreparedInsert();
    }
}
