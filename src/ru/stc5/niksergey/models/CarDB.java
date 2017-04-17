package ru.stc5.niksergey.models;

import java.util.Date;

/**
 * Created by sergey on 16.04.17.
 */
public class CarDB {
    private CarModelDB carModelDB;
    private String vin;
    private Date producedDate;
    private boolean available;

    public CarDB(CarModelDB carModelDB, String vin, Date producedDate) {
        this.carModelDB = carModelDB;
        this.vin = vin;
        this.producedDate = producedDate;
        this.available = true;
    }

    public CarModelDB getCarModelDB() {
        return carModelDB;
    }

    public void setCarModelDB(CarModelDB carModelDB) {
        this.carModelDB = carModelDB;
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

    /**
     * Shows whether the car is available to rent or not
     * @return availability to rent the car
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets whether the car is available to rent or not
     * @param status boolean value changing status of the car
     */
    public void setAvailable(boolean status) {
        available = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDB car = (CarDB) o;

        return vin.equals(car.vin);
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }
}
