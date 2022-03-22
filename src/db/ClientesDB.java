package db;

import conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientesDB {
    public void save() throws SQLException {
        String sql = "INSERT INTO `estudos`.`Clientes` (`id`, `nome`, `email`, `cpf`, `telefone`) VALUES ('', 'Jônatha', 'jonatha949@gmail.com', '123.456.789-00', '(11) 1234-5678');\n ";
        Connection conn = ConnectionFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            System.out.println(stmt.executeUpdate(sql));
            ConnectionFactory.Close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
