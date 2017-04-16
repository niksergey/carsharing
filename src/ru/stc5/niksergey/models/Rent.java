package ru.stc5.niksergey.models;

import java.util.Date;

/**
 * Created by sergey on 16.04.17.
 */
public class Rent {
    private Car car;
    private Leaser leaser;
    private Date startDate;
    private Date finishDate;

    public Rent(Car car, Leaser leaser) {
        this.car = car;
        this.leaser = leaser;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Leaser getLeaser() {
        return leaser;
    }

    public void setLeaser(Leaser leaser) {
        this.leaser = leaser;
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
