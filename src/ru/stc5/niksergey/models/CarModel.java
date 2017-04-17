package ru.stc5.niksergey.models;


import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CarModel {
    private final static Logger LOGGER = Logger.getLogger(CarModel.class);

    private String manufacturer;
    private String model;
    private String gear;
    private int power;

    public CarModel(String manufacturer, String model, String gear, int power) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.gear = gear;
        this.power = power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public static Set<CarModel> getCarModel(ResultSet queryRes) {
        Set<CarModel> models = new HashSet<>(16);
        CarModel cm;
        if (queryRes != null) {
            try {
                while (queryRes.next()) {
                    cm = new CarModel(queryRes.getString("car_model_manufacturer"),
                            queryRes.getString("car_model_model"),
                            queryRes.getString("car_model_gear"),
                            queryRes.getInt("car_model_power"));
                    models.add(cm);
                }
            } catch (SQLException e) {
                LOGGER.warn("SQLException in getCarModel();", e);
            }
        }
        return models;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarModel carModel = (CarModel) o;

        return model != null ? model.equals(carModel.model) : carModel.model == null;
    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
