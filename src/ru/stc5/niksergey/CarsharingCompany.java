package ru.stc5.niksergey;

import ru.stc5.niksergey.models.Car;
import ru.stc5.niksergey.models.CarModel;
import ru.stc5.niksergey.models.Leaser;
import ru.stc5.niksergey.models.Rent;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sergey on 16.04.17.
 */
public class CarsharingCompany {
    Set<Car> carPark;
    Set<Leaser> leasers;
    Set<CarModel> carModels;
    Set<Rent> rents;

    public CarsharingCompany() {
        carPark = new HashSet<>(128);
        leasers = new HashSet<>(2096);
        carModels = new HashSet<>(16);
        rents = new HashSet<>(32768);
    }

    public void appendCar(CarModel carModel, String vin, Date producedDate) {
        Car newOne = new Car(carModel, vin, producedDate);
        carPark.add(newOne);
    }

    public int getParkSize() {
        return carPark.size();
    }
}
