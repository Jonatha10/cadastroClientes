import classe.Clientes;
import db.ClientesDB;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class Testeconexao {
    public static void main(String[] args) throws SQLException {

        List<Clientes> clientesList2 = selecionarPeloNome("rem");
        System.out.println(clientesList2);
    }
    public static void inserir() throws SQLException {
        Clientes clientes = new Clientes("mario", "mario@gmail.com", "12345689", "(11) 1111-4444");
        ClientesDB clientesDB = new ClientesDB();
        ClientesDB.save(clientes);
    }
    public static void deletar() throws SQLException {
        Clientes clientes = new Clientes();
        clientes.setId(5);
        ClientesDB.delete(clientes);
    }
    public static void atualizar() throws SQLException {
        Clientes clientes = new Clientes(1, "maria", "maria123@gmail.com", "123.456.544-95", "(11) 9123-4568");
        ClientesDB.update(clientes);
    }
    public static List<Clientes> selecionarTudo() throws SQLException {
        return ClientesDB.selectAll();
    }
    public static List<Clientes> selecionarPeloNome(String nome) throws SQLException {
        return ClientesDB.searchByName(nome);
    }

}
