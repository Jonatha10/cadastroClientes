import conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Testeconexao {
    public static void main(String[] args) throws SQLException {
        Connection conexao = ConnectionFactory.getConexao();

        try {
            System.out.println("funciona");
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
