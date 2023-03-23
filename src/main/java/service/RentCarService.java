package service;

import bl.Util;
import dao.RentCarDAO;
import entity.RentCar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentCarService extends Util implements RentCarDAO {
    Connection connection = getConnection();

    @Override
    public void add(RentCar rentCar) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO RENTCAR (id, car_id, client_id, date_start_rent, date_finish_rent) VALUES(?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, rentCar.getId());
            preparedStatement.setLong(2, rentCar.getCarId());
            preparedStatement.setLong(3, rentCar.getClientId());
            preparedStatement.setDate(4, Date.valueOf(rentCar.getDateStartRent()));
            preparedStatement.setDate(5, Date.valueOf(rentCar.getDateFinalRent()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public List<RentCar> getAll() {
        List<RentCar> rentCarList = new ArrayList<>();
        String sql = "SELECT *";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                RentCar rentCar = new RentCar(resultSet.getDate("yearsOfRelease").toLocalDate(), resultSet.getDate("yearsOfRelease").toLocalDate(), resultSet.getLong("id"), resultSet.getLong("client_id"), resultSet.getLong("car_id"));
                rentCarList.add(rentCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentCarList;
    }

    @Override
    public RentCar getByCarIdAndClientId(Long id, Long carId, Long clientId) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM RENTCAR WHERE id = ? AND carId = ? AND cleintId = ?";

        RentCar rentCar = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, carId);
            preparedStatement.setLong(3, clientId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rentCar = new RentCar(resultSet.getDate("date_start_rent").toLocalDate(), resultSet.getDate("date_finish_rent").toLocalDate(), resultSet.getLong("id"), resultSet.getLong("car_id"), resultSet.getLong("client_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentCar;
    }

    @Override
    public void update(RentCar rentCar) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE RENTCAR  SET date_start_rent = ? AND date_finish_rent = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, Date.valueOf(rentCar.getDateStartRent()));
            preparedStatement.setDate(2, Date.valueOf(rentCar.getDateFinalRent()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) connection.close();
        }
    }

    @Override
    public void remove(RentCar rentCar) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Rent_car WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, rentCar.getCarId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }
}
