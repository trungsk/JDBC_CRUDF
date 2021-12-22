package com.jdbc.crud;

import com.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    static Connection connection = null;
    static PreparedStatement pStatement = null;
    private static String deleteSQL = "delete from hero where id = ?;";

    public static void delete(){
        try {
            connection = JDBCUtil.getConnection();
            pStatement = connection.prepareStatement(deleteSQL);
            pStatement.setInt(1, 1);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
    }
}
