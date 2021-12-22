package com.jdbc.crud;

import com.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {
    static String insertSQL = "insert into hero values \r\n" +
                                "(null, ?, ?, ?, ?);";
    public static void create() {
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = JDBCUtil.getConnection();
            pStatement = connection.prepareStatement(insertSQL);
            pStatement.setString(1, "Jayce");
            pStatement.setInt(2, 23);
            pStatement.setString(3, "human");
            pStatement.setString(4, "top");
            System.out.println(pStatement);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
    }
}
