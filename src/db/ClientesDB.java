package db;

import classe.Clientes;
import conn.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDB {
    public static void save(Clientes clientes) throws SQLException {
        String sql = "INSERT INTO `estudos`.`Clientes` (`nome`, `email`, `cpf`, `telefone`) VALUES ( '" + clientes.getNome() + "', '" + clientes.getEmail() + "', '" + clientes.getCpf() + "', '" + clientes.getTelefone() + "')\n ";
        Connection conn = ConnectionFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            System.out.println(stmt.executeUpdate(sql));
            ConnectionFactory.Close(conn, stmt);
            System.out.println("Dados registrados com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Clientes clientes) throws SQLException {
        if (clientes == null || clientes.getId() == null) {
            System.out.println("Não foi possivel excluir os dados");
            return;
        } else {
            String sql = "DELETE FROM `estudos`.`Clientes` WHERE `id` ='" + clientes.getId() + "'";
            Connection conn = ConnectionFactory.getConexao();
            try {
                Statement stmt = conn.createStatement();
                System.out.println(stmt.executeUpdate(sql));
                ConnectionFactory.Close(conn, stmt);
                System.out.println("Dados removidos com sucesso");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(Clientes clientes) throws SQLException {
        if (clientes == null || clientes.getId() == null) {
            System.out.println("Não foi possivel atualizar os dados");
            return;
        } else {
            String sql = "UPDATE `estudos`.`Clientes` SET `nome` = '" + clientes.getNome() + "', `email` = '" + clientes.getEmail() + "', `cpf` = '" + clientes.getCpf() + "' ,`telefone` = '" + clientes.getTelefone() + "'  WHERE (`id` = '" + clientes.getId() + "');";

            Connection conn = ConnectionFactory.getConexao();
            try {
                Statement stmt = conn.createStatement();
                System.out.println(stmt.executeUpdate(sql));
                ConnectionFactory.Close(conn, stmt);
                System.out.println("Dados atualizados com sucesso");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Clientes> selectAll() throws SQLException {
        String sql = "SELECT * FROM estudos.Clientes";
        Connection conn = ConnectionFactory.getConexao();
        List<Clientes> clientesList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                clientesList.add(new Clientes(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("email"), resultSet.getString("cpf"), resultSet.getString("telefone")));

            }
            ConnectionFactory.Close(conn, stmt, resultSet);
            return clientesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Clientes> searchByName(String nome) throws SQLException {
        String sql = "SELECT * FROM estudos.Clientes where nome like '%" + nome + "%'";
        Connection conn = ConnectionFactory.getConexao();
        List<Clientes> clientesList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                clientesList.add(new Clientes(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("email"), resultSet.getString("cpf"), resultSet.getString("telefone")));

            }
            ConnectionFactory.Close(conn, stmt, resultSet);
            return clientesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void selectMetaData() throws SQLException {
        String sql = "Select * from estudos.Clientes";
        Connection conn = ConnectionFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            resultSet.next();
            int qtdColuna = resultSetMetaData.getColumnCount();
            System.out.println("Quantidade de colunas: " + qtdColuna);
            for (int i = 1; i <= qtdColuna; i++) {
                System.out.println("Tabela: " + resultSetMetaData.getTableName(i));
                System.out.println("Nome coluna: " + resultSetMetaData.getColumnName(i));
                System.out.println("Tamanho coluna: " + resultSetMetaData.getColumnDisplaySize(i));
            }
            ConnectionFactory.Close(conn, stmt, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkDriverStatus() throws SQLException {
        Connection conn = ConnectionFactory.getConexao();
        try {
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.println("Suporta TYPE_FORWARD_ONLY");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" e também suporta CONCUR_UPDATABLE");
                }
            }
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" e também suporta CONCUR_UPDATABLE");
                }
            }
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" e também suporta CONCUR_UPDATABLE");
                }
            }
            ConnectionFactory.Close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}