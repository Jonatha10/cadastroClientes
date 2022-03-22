package db;

import classe.Clientes;
import conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientesDB {
    public static void save(Clientes clientes) throws SQLException {
        String sql = "INSERT INTO `estudos`.`Clientes` (`nome`, `email`, `cpf`, `telefone`) VALUES ( '"+ clientes.getNome() +"', '"+ clientes.getEmail() +"', '"+ clientes.getCpf() +"', '"+ clientes.getTelefone() +"')\n ";
        Connection conn = ConnectionFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            System.out.println(stmt.executeUpdate(sql));
            ConnectionFactory.Close(conn, stmt);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete (Clientes clientes) throws SQLException {
        if (clientes == null || clientes.getId() == null){
            System.out.println("Não foi possivel excluir o registro");
            return;
        }else{
            String sql = "DELETE FROM `estudos`.`Clientes` WHERE `id` ='"+ clientes.getId() +"'";
            Connection conn = ConnectionFactory.getConexao();
            try {
                Statement stmt = conn.createStatement();
                System.out.println(stmt.executeUpdate(sql));
                ConnectionFactory.Close(conn, stmt);
                System.out.println("Registro removido com sucesso");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        }




}
