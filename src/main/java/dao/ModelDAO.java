package dao;

import entity.Model;

import java.sql.SQLException;
import java.util.List;

public interface ModelDAO {
    //crate
    void add(Model model) throws SQLException;

    //read
    List<Model> getAll();

    Model getByIdAndMarkId(Long id, Long markId);

    //update
    void update(Model model) throws SQLException;

    //delete
    void remove(Model model) throws SQLException;
}
