package com.jdbc.crud;

import com.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    static Connection connection = null;
    static PreparedStatement pStatement = null;
    private static String updateSQL = "update hero set name = 'Caitlyn' where id = ?;";
    public static void update(){
        try {
            connection = JDBCUtil.getConnection();
            pStatement = connection.prepareStatement(updateSQL);

            pStatement.setInt(1, 1);
            System.out.println(pStatement);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
    }
}
