package ru.stc5.niksergey.models;

import java.util.Date;

/**
 * Created by sergey on 16.04.17.
 */
public class RentDB {
    private CarDB car;
    private LeaserDB leaserDB;
    private Date startDate;
    private Date finishDate;

    public RentDB(CarDB car, LeaserDB leaserDB) {
        this.car = car;
        this.leaserDB = leaserDB;
    }

    public CarDB getCar() {
        return car;
    }

    public void setCar(CarDB car) {
        this.car = car;
    }

    public LeaserDB getLeaserDB() {
        return leaserDB;
    }

    public void setLeaserDB(LeaserDB leaserDB) {
        this.leaserDB = leaserDB;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}
