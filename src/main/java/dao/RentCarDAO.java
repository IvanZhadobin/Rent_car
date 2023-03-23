package dao;

import entity.RentCar;
import java.sql.SQLException;
import java.util.List;

public interface RentCarDAO {
    //crate
    void add(RentCar rentCar) throws SQLException;

    //read
    List<RentCar> getAll();

    RentCar getByCarIdAndClientId(Long id, Long carId, Long clientId);

    //update
    void update(RentCar rentCar) throws SQLException;

    //delete
    void remove(RentCar rentCar) throws SQLException;
}
