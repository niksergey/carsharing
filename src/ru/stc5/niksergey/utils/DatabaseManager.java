package ru.stc5.niksergey.utils;

import org.apache.log4j.Logger;
import ru.stc5.niksergey.models.CarModel;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


public class DatabaseManager {
    private final static Logger LOGGER = Logger.getLogger(DatabaseManager.class);

    private Connection initConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Database driver not found");
        }

        try {
             connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/carsharing","innokentiy", "kesha123");
        } catch (SQLException e) {
            LOGGER.error("Database connection has not been established.");
        }

        return connection;
    }

    public ResultSet select(String tableName) {
        Connection connection = initConnection();

        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM " + tableName + ";");

        } catch (SQLException e) {
            LOGGER.warn("SQLException in SELECT statement", e);
        }
        return result;
    }

    public void insert(CarModel carModel) {
        Connection connection = initConnection();
        String query = "INSERT INTO car_model (car_model_manufacturer, car_model_model," +
                " car_model_power) " +
                " VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, carModel.getManufacturer());
            preparedStatement.setString(2, carModel.getModel());
            preparedStatement.setInt(3, carModel.getPower());
            //            preparedStatement.setString(4, carModel.getGear());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("SQLException in INSERT statement", e);
        }
    }

    public void delete(CarModel carModel) {
        Connection connection = initConnection();

        String query = "DELETE FROM car_model WHERE car_model_model=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, carModel.getModel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("SQLException in DELETE statement", e);
        }
    }

    public void update(CarModel carModel) {
        Connection connection = initConnection();
        String query = "UPDATE car_model SET car_model_manufacturer=?," +
                " car_model_power=? WHERE car_model_model=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, carModel.getManufacturer());
            preparedStatement.setInt(2, carModel.getPower());
            preparedStatement.setString(4, carModel.getModel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("SQLException in UPDATE statement", e);
        }
    }

    public void clearTable() {
        Connection connection = initConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM book;");
        } catch (SQLException e) {
            LOGGER.warn("SQLException in ClearTable method", e);
        }
    }
}
