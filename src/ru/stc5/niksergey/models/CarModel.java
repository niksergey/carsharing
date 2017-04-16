package ru.stc5.niksergey.models;


public class CarModel {
    private String manufacturer;
    private String model;
    private Gear gear;
    private int power;

    public CarModel(String manufacturer, String model, Gear gear, int power) {
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

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
