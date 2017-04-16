package ru.stc5.niksergey.models;

import java.util.Date;

/**
 * Created by sergey on 16.04.17.
 */
public class Car {
    private CarModel carModel;
    private String vin;
    private Date producedDate;
    private boolean available;

    public Car(CarModel carModel, String vin, Date producedDate) {
        this.carModel = carModel;
        this.vin = vin;
        this.producedDate = producedDate;
        this.available = true;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(Date producedDate) {
        this.producedDate = producedDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        available = status;
    }
}
