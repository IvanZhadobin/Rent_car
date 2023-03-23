package service;



import dao.ClientDAO;
import entity.Client;
import bl.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService extends Util implements ClientDAO {
    Connection connection = getConnection();

    @Override
    public void add(Client client) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO CLIENT (id, lastname, firstname, patronymic, birthday, passport, driver_license) VALUES(?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, client.getId());
            preparedStatement.setString(2, client.getLastname());
            preparedStatement.setString(2, client.getFirstname());
            preparedStatement.setString(2, client.getPatronymic());
            preparedStatement.setDate(3, Date.valueOf(client.getBirthday()));
            preparedStatement.setString(5, client.getPassport());
            preparedStatement.setString(6, client.getDriverLicense());

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
    public List<Client> getAll() {
        List<Client> clientList = new ArrayList<>();
        String sql = "SELECT *";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("lastname"),
                        resultSet.getString("firstname"),
                        resultSet.getString("patronymic"),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getString("passport"),
                        resultSet.getString("driver_license")
                );
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientList;
    }

    @Override
    public Client getById(Long id) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM CLIENT WHERE id = ?";
        Client client = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                client = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("lastname"),
                        resultSet.getString("firstname"),
                        resultSet.getString("patronymic"),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getString("passport"),
                        resultSet.getString("driver_license")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void update(Client client) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE CAR SET lastname = ?, firstname = ?, patronymic = ?, birthday = ?, passport = ?, driver_license = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, client.getLastname());
            preparedStatement.setString(2, client.getFirstname());
            preparedStatement.setString(3, client.getPatronymic());
            preparedStatement.setDate(4, Date.valueOf(client.getBirthday()));
            preparedStatement.setString(5, client.getPassport());
            preparedStatement.setString(6, client.getDriverLicense());

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
    public void remove(Client client) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM client WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, client.getId());
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
