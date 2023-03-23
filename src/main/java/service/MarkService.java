package service;

import bl.Util;
import dao.MarkDAO;
import entity.Mark;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarkService extends Util implements MarkDAO {

    Connection connection = getConnection();

    @Override
    public void add(Mark mark) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO MARK (id, mark_name) VALUES(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, mark.getId());
            preparedStatement.setString(2, mark.getMarkName());
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
    public List<Mark> getAll() {
        List<Mark> carMark = new ArrayList<>();
        String sql = "SELECT *";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Mark mark = new Mark(
                        resultSet.getLong("id"),
                        resultSet.getString("mark_name")
                );
                carMark.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carMark;
    }

    @Override
    public Mark getById(Long id) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM MARK WHERE id = ?";
        Mark mark = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                mark = new Mark(
                        resultSet.getLong("id"),
                        resultSet.getString("mark_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mark;
    }

    @Override
    public void update(Mark mark) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE MARK SET mark_name = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mark.getMarkName());
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
    public void remove(Mark mark) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM mark WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, mark.getId());
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
