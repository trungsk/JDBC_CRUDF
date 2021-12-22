package com.jdbc.crud;

import com.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
    static Connection connection = null;
    static PreparedStatement pStatement = null;
    private static String findByIdSQL = "select * from hero where id = ?;";

    public static void findById(int id) {
        try {
            connection = JDBCUtil.getConnection();
            pStatement = connection.prepareStatement(findByIdSQL);
            pStatement.setInt(1, id);
            ResultSet rs = pStatement.executeQuery();
            System.out.println(pStatement);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") +
                        " - name: " + rs.getString("name") +
                        " - age: " + rs.getInt("age") +
                        " - type: " + rs.getString("type") +
                        " - role: " + rs.getString("role"));
            }

        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
    }

}
