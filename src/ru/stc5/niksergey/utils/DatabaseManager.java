package ru.stc5.niksergey.utils;

import org.apache.log4j.Logger;
import ru.stc5.niksergey.models.CarModelDB;
import ru.stc5.niksergey.models.xjc.Car;
import ru.stc5.niksergey.models.xjc.CarModel;
import ru.stc5.niksergey.models.xjc.Leaser;
import ru.stc5.niksergey.models.xjc.Rent;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DatabaseManager {
    private final static Logger LOGGER = Logger.getLogger(DatabaseManager.class);

    public Connection initConnection() {
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

    public Set<CarModel> getCarModels() {
        Set<CarModel> models = new HashSet<>();
        ResultSet result;

        try(Connection conn = initConnection()) {
            Statement statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM car_model;");
            models = carModelsFromResult(result);
        } catch (SQLException e) {
            LOGGER.warn("SQLException in getCarModels() SELECT statement", e);
        }

        return models;
    }

    public CarModel getCarModel(int id) {
        CarModel model = null;
        ResultSet result;

        try(Connection conn = initConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM car_model WHERE car_model_id = (?);");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            model = carModelsFromResult(result).iterator().next();
        } catch (SQLException e) {
            LOGGER.warn("SQLException in getCarModel() SELECT statement", e);
        }

        return model;
    }

    private Set<CarModel> carModelsFromResult(ResultSet result) {
        Set<CarModel> models = new HashSet<>();
        try {
            while (result.next()) {
                CarModel model = new CarModel();
                model.setManufacturer(result.getString("car_model_manufacturer"));
                model.setModel(result.getString("car_model_model"));
                model.setGear(result.getString("car_model_gear"));
                model.setPower(result.getInt("car_model_power"));
                model.setId(result.getInt("car_model_id"));
                models.add(model);
            }
        } catch (SQLException e) {
            LOGGER.warn("SQLException in carModelsFromResult()", e);
        }

        return models;
    }

    public Set<Car> getCars() {
        Set<Car> cars = new HashSet<>();
        ResultSet result;

        try(Connection conn = initConnection()) {
            Statement statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM car;");
            cars = carsFromResult(result);
        } catch (SQLException e) {
            LOGGER.warn("SQLException in getCars() SELECT statement", e);
        }
        return cars;
    }

    public Car getCar(int id) {
        Car car = null;
        ResultSet result;

        try(Connection conn = initConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM car WHERE car_id = (?);");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            car = carsFromResult(result).iterator().next();
        } catch (SQLException e) {
            LOGGER.warn("SQLException in getCar() SELECT statement", e);
        }

        return car;
    }

    private Set<Car> carsFromResult(ResultSet result) {
        Set<Car> cars = new HashSet<>();
        try {
            while (result.next()) {
                Car car = new Car();
                car.setCarModel(this.getCarModel(result.getInt("car_model_car_model_id")));
                car.setVin(result.getString("car_vin"));
                car.setYear(result.getInt("car_year"));
                car.setId(result.getInt("car_id"));
                cars.add(car);
            }
        } catch (SQLException e) {
            LOGGER.warn("SQLException in carsFromResult()", e);
        }

        return cars;
    }

    public Set<Leaser> getLeasers() {
        Set<Leaser> leasers = new HashSet<>();
        ResultSet result;

        try(Connection conn = initConnection()) {
            Statement statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM leaser;");
            leasers = leasersFromResult(result);
        } catch (SQLException e) {
            LOGGER.warn("SQLException in getLeasers() SELECT statement", e);
        }

        return leasers;
    }

    public Leaser getLeaser(int id) {
        Leaser leaser = null;
        ResultSet result;

        try(Connection conn = initConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM leaser WHERE leaser_id = (?);");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            leaser = leasersFromResult(result).iterator().next();
        } catch (SQLException e) {
            LOGGER.warn("SQLException in getLeaser() SELECT statement", e);
        }

        return leaser;
    }

    private Set<Leaser> leasersFromResult(ResultSet result) {
        Set<Leaser> leasers = new HashSet<>();
        try {
            while (result.next()) {
                Leaser leaser = new Leaser();
                leaser.setFirstName(result.getString("leaser_first_name"));
                leaser.setSecondName(result.getString("leaser_second_name"));
                leaser.setLastName(result.getString("leaser_last_name"));
                leaser.setPhoneNumber(result.getString("leaser_phone_number"));
                leaser.setEmail(result.getString("leaser_email"));
                leaser.setId(result.getInt("leaser_id"));
                leasers.add(leaser);
            }
        } catch (SQLException e) {
            LOGGER.warn("SQLException in leasersFromResult() result", e);
        }

        return leasers;
    }

    public Set<Rent> getRents() {
        Set<Rent> rents = new HashSet<>();
        ResultSet result;

        try(Connection conn = initConnection()) {
            Statement statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM rent;");
            while (result.next()) {
                Rent rent = new Rent();
                rent.setCar(getCar(result.getInt("car_car_id")));
                rent.setLeaser(getLeaser(result.getInt("leaser_leaser_id")));
                rent.setStartDate(
                        XMLCalendarToDate.toXMLGregorianCalendar(
                                result.getDate("rent_start_date")));
                rent.setFinishDate(
                        XMLCalendarToDate.toXMLGregorianCalendar(
                                result.getDate("rent_finish_date")));
                rents.add(rent);
            }
        } catch (SQLException e) {
            LOGGER.warn("SQLException in getRents() SELECT statement", e);
        }

        return rents;
    }

    public void uploadCarModels(Set<CarModel> models) {
        try(Connection conn = initConnection()) {
            for (CarModel cm : models) {
                String query = "INSERT INTO car_model (car_model_manufacturer, car_model_model," +
                        " car_model_gear, car_model_power, car_model_id) " +
                        " VALUES (?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, cm.getManufacturer());
                preparedStatement.setString(2, cm.getModel());
                preparedStatement.setString(3, cm.getGear());
                preparedStatement.setInt(4, cm.getPower());
                preparedStatement.setInt(5, cm.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.warn("SQLException in uploadCarModels() INSERT statement", e);
        }
    }

    public void uploadCars(Set<Car> cars) {
        try(Connection conn = initConnection()) {
            for (Car cm : cars) {
                String query = "INSERT INTO car (car_vin, car_year," +
                        " car_model_car_model_id, car_id) " +
                        " VALUES (?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, cm.getVin());
                preparedStatement.setInt(2, cm.getYear());
                preparedStatement.setInt(3, cm.getCarModel().getId());
                preparedStatement.setInt(4, cm.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.warn("SQLException in uploadCarModels() INSERT statement", e);
        }
    }

    public void uploadLeasers(Set<Leaser> leasers) {
        try(Connection conn = initConnection()) {
            for (Leaser ls : leasers) {
                String query = "INSERT INTO leaser (leaser_first_name, leaser_second_name," +
                        "leaser_last_name, leaser_email, leaser_phone_number," +
                        " leaser_id) " +
                        " VALUES (?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, ls.getFirstName());
                preparedStatement.setString(2, ls.getSecondName());
                preparedStatement.setString(3, ls.getLastName());
                preparedStatement.setString(4, ls.getEmail());
                preparedStatement.setString(5, ls.getPhoneNumber());
                preparedStatement.setInt(6, ls.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.warn("SQLException in uploadCarModels() INSERT statement", e);
        }
    }

    public void uploadRents(Set<Rent> rents) {
        try(Connection conn = initConnection()) {
            for (Rent rn : rents) {
                String query = "INSERT INTO rent (leaser_leaser_id, car_car_id," +
                        " rent_start_date, rent_finish_date, rent_id) " +
                        " VALUES (?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, rn.getLeaser().getId());
                preparedStatement.setInt(2, rn.getCar().getId());
                preparedStatement.setDate(3, XMLCalendarToDate.toSqlDate(rn.getStartDate()));
                preparedStatement.setDate(4, XMLCalendarToDate.toSqlDate(rn.getFinishDate()));
                preparedStatement.setInt(5, rn.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.warn("SQLException in uploadCarModels() INSERT statement", e);
        }
    }

    public void clearDatabase() {
        try (Connection connection = initConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE rent, car, leaser, car_model;");
        } catch (SQLException e) {
            LOGGER.warn("SQLException in clearDatabase() method", e);
        }
    }
}
