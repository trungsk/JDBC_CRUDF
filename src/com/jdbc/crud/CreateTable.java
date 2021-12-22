package com.jdbc.crud;

import com.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * this class is like a helper helping you to create a table without touching mySQL Workbench
 */
public class CreateTable {
    static Connection connection = null;
    static Statement statement = null;
    private static String createTableHeroSQL =
            "   create table hero (\r\n" +
            "   id int primary key auto_increment,\r\n" +
            "   name varchar(30),\r\n" +
            "   age int,\r\n" +
            "   type varchar(30),\r\n" +  // type: human, monster, yordle, demigod, furry
            "   role varchar(10));";   // role: top, mid, adc, supporter, jungler

    private static String dropSchema =
            "drop table if exists hero;";

    public static void dropSchema(){

        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            statement.execute(dropSchema);
            System.out.println("table hero has been created");
        }catch (SQLException e){
            JDBCUtil.printSQLException(e);
        }finally {
            try {
                if (statement!=null) statement.close();
                if (connection!=null)connection.close();
            } catch (SQLException e) {
                JDBCUtil.printSQLException(e);
            }
        }
    }
    public static void createTableHero(){
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            statement.execute(createTableHeroSQL);
            System.out.println("table hero has been created");
        }catch (SQLException e){
            JDBCUtil.printSQLException(e);
        }finally {
            try {
                if (statement!=null) statement.close();
                if (connection!=null)connection.close();
            } catch (SQLException e) {
                JDBCUtil.printSQLException(e);
            }
        }
    }
}
