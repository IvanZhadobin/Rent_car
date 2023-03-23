package dao;

import entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDAO {
    //crate
    void add(Car car) throws SQLException;

    //read
    List<Car> getAll();

    Car getByIdAndModelId(Long id, Long modelId);

    //update
    void update(Car car) throws SQLException;

    //delete
    void remove(Car car) throws SQLException;

}
