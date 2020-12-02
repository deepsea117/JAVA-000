package com.deepsea.jdbc;

import java.sql.*;

public class JdbcDelete {

    public void exeDelete(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/energylot", "postgres", "postgresql");
            Statement stm = conn.createStatement();
            String sql = "delete from sys_user where user_id = 'geek1'";
            int result = stm.executeUpdate(sql);
            System.out.println(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exePreparedDelete(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/energylot", "postgres", "postgresql");
            PreparedStatement pstm = conn.prepareStatement("delete from sys_user where user_id = ?");
            pstm.setString(1, "geek3");
            int result = pstm.executeUpdate();
            System.out.println(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        JdbcDelete jdbcDelete = new JdbcDelete();
        jdbcDelete.exeDelete();
        jdbcDelete.exePreparedDelete();
    }
}
