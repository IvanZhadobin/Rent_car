package service;

import bl.Util;
import dao.ModelDAO;
import entity.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelService extends Util implements ModelDAO {
    Connection connection = getConnection();

    @Override
    public void add(Model model) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO MODEL (id, mark_id, model_name) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, model.getId());
            preparedStatement.setLong(2, model.getMarkId());
            preparedStatement.setString(3, model.getModelName());
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
    public List<Model> getAll() {
        List<Model> modelList = new ArrayList<>();
        String sql = "SELECT *";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Model model = new Model(
                        resultSet.getLong("id"),
                        resultSet.getLong("mark_id"),
                        resultSet.getString("model_name")
                );
                modelList.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    @Override
    public Model getByIdAndMarkId(Long id, Long markId) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM MODEL WHERE id = ? AND mark_id = ?";
        Model model = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, markId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                model = new Model(
                        resultSet.getLong("id"),
                        resultSet.getLong("mark_id"),
                        resultSet.getString("model_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public void update(Model model) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE MODEL SET model_name = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, model.getModelName());
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
    public void remove(Model model) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM model WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, model.getId());
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
