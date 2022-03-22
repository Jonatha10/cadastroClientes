import classe.Clientes;
import db.ClientesDB;

import java.sql.SQLException;

public class Testeconexao {
    public static void main(String[] args) throws SQLException {

        deletar();

    }
    public static void inserir() throws SQLException {
        Clientes clientes = new Clientes("joao","joao123@gmail.com","123.456.789-00","(71) 91234-5678");
        ClientesDB clientesDB = new ClientesDB();
        ClientesDB.save(clientes);
    }
    public static void deletar() throws SQLException {
        Clientes clientes = new Clientes();
        clientes.setId(2);
        ClientesDB.delete(clientes);
    }

}
