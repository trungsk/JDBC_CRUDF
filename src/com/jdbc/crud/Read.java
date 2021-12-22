package com.jdbc.crud;

import com.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {
    static Connection connection = null;
    static Statement statement = null;
    private static String getAllSQL = "select * from hero;";

    public static void getAllHero() {
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(getAllSQL);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + " - name: " + rs.getString("name") +
                        " - age: " + rs.getInt("age") + " - type: " + rs.getString("type") +
                        " - role: " + rs.getString("role"));
            }
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
    }
}
