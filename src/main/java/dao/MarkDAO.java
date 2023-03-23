package dao;

import entity.Mark;

import java.sql.SQLException;
import java.util.List;

public interface MarkDAO {
    //crate
    void add(Mark mark) throws SQLException;

    //read
    List<Mark> getAll();

    Mark getById(Long id);

    //update
    void update(Mark mark) throws SQLException;

    //delete
    void remove(Mark mark) throws SQLException;
}
