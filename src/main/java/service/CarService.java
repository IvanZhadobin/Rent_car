package service;

import bl.Util;
import dao.CarDAO;
import entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarService extends Util implements CarDAO {
    Connection connection = getConnection();

    @Override
    public void add(Car car) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO CAR (id, mark, year_of_release, mileage, rating, price, model_id) VALUES(?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, car.getId());
            preparedStatement.setString(2, car.getMark());
            preparedStatement.setDate(3, Date.valueOf(car.getYearOfRelease()));
            preparedStatement.setInt(4, car.getMileage());
            preparedStatement.setString(5, car.getRating());
            preparedStatement.setInt(6, car.getPrice());
            preparedStatement.setLong(7, car.getModelId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }
    }

    @Override
    public List<Car> getAll() {
        List<Car> carList = new ArrayList<>();
        String sql = "SELECT *";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getLong("id"),
                        resultSet.getString("mark"),
                        resultSet.getDate("year_of_release").toLocalDate(),
                        resultSet.getInt("mileage"),
                        resultSet.getString("rating"),
                        resultSet.getInt("price"),
                        resultSet.getLong("model_id")
                );
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carList;
    }

    @Override
    public Car getByIdAndModelId(Long id, Long modelId) {
        String sql = "SELECT * FROM CAR WHERE id = ? AND model_id = ?";
        Car car = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, modelId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                car = new Car(
                        resultSet.getLong("id"),
                        resultSet.getString("mark"),
                        resultSet.getDate("year_of_release").toLocalDate(),
                        resultSet.getInt("mileage"),
                        resultSet.getString("rating"),
                        resultSet.getInt("price"),
                        resultSet.getLong("model_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public void update(Car car) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE CAR SET mark = ?, year_of_release = ?, mileage = ?, rating = ?, price = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getMark());
            preparedStatement.setDate(2, Date.valueOf(car.getYearOfRelease()));
            preparedStatement.setInt(3, car.getMileage());
            preparedStatement.setString(4, car.getRating());
            preparedStatement.setInt(5, car.getPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null)
                connection.close();
        }
    }

    @Override
    public void remove(Car car) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM car WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, car.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null)
                connection.close();
        }
    }
}
