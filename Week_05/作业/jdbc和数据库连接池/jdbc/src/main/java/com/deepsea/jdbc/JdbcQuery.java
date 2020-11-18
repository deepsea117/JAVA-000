package com.deepsea.jdbc;

import java.sql.*;

public class JdbcQuery {

    public void doQuery(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/energylot", "postgres", "postgresql");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select id, user_id, user_name from sys_user where status = '1' order by id");
            while (rs.next()){
                System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPreparedQuery(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/energylot", "postgres", "postgresql");
            PreparedStatement pstm = conn.prepareStatement("select id, user_id, user_name from sys_user where status = ? order by id");
            pstm.setString(1, "1");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        JdbcQuery jdbcQuery = new JdbcQuery();
        jdbcQuery.doQuery();
        jdbcQuery.doPreparedQuery();

    }
}
