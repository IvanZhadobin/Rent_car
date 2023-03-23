package dao;
import entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {
    //crate
    void add(Client client) throws SQLException;

    //read
    List<Client> getAll();

    Client getById(Long id);

    //update
    void update(Client client) throws SQLException;

    //delete
    void remove(Client client) throws SQLException;
}
