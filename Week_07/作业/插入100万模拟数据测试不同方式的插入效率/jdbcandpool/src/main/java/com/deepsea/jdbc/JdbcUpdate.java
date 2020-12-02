package com.deepsea.jdbc;

import java.sql.*;

public class JdbcUpdate {

    public void doUpdate(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/energylot", "postgres", "postgresql");
            Statement stm = conn.createStatement();
            String sql = "update sys_user set status = '0' where user_id = 'geek1'";
            int result = stm.executeUpdate(sql);
            System.out.println(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exePreparedUpdate(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/energylot", "postgres", "postgresql");
            PreparedStatement pstm = conn.prepareStatement("update sys_user set status = ? where user_id = ?");
            pstm.setString(1, "2");
            pstm.setString(2, "geek3");
            int result = pstm.executeUpdate();
            System.out.println(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        JdbcUpdate jdbcUpdate = new JdbcUpdate();
        jdbcUpdate.doUpdate();
        jdbcUpdate.exePreparedUpdate();

    }
}
