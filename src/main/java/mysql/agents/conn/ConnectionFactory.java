package mysql.agents.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3307/sisantinho";
        String username = "root";
        String password = "root";

        return DriverManager.getConnection(url, username, password);
    }
}
