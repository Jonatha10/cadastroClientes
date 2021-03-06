package conn;

import java.sql.*;

public class ConnectionFactory {
    public static Connection getConexao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/estudos";
        String user = "root";
        String password = "20151718";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void Close(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Close(Connection connection, Statement stmt) {
        Close(connection);
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Close(Connection conn, Statement stmt, ResultSet resultSet) {
        Close(conn, stmt);
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

