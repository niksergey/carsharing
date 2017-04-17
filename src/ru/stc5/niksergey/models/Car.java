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

        Car car = (Car) o;

        return vin.equals(car.vin);
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }
}
