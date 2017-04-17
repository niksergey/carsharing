package ru.stc5.niksergey;

import ru.stc5.niksergey.models.xjc.Car;
import ru.stc5.niksergey.models.xjc.CarModel;
import ru.stc5.niksergey.models.xjc.Leaser;
import ru.stc5.niksergey.models.xjc.Rent;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sergey on 16.04.17.
 */
public class CarsharingCompany {
    private Set<Car> carPark;
    private Set<Leaser> leasers;
    private Set<CarModel> carModels;
    private Set<Rent> rents;

    public CarsharingCompany() {
        carPark = new HashSet<>(128);
        leasers = new HashSet<>(2096);
        carModels = new HashSet<>(16);
        rents = new HashSet<>(32768);
    }

    /**
     * Append a Car given CarModel, VIN and production date to
     * carPark collection.
     * @param carModel CarModel instance containing Manufacturer, model, gear
     *                 type and engine power
     * @param vin String containing car's VIN
     * @param producedDate Date containing car production date
     */
    public void appendCar(CarModel carModel, String vin, Date producedDate) {
        Car newOne = new Car();
        carPark.add(newOne);
    }

    public void appendCarModel(CarModel cm) {
        carModels.add(cm);
    }

    public void appendAllCarModels(Set<CarModel> bunchCarModels) {
        carModels.addAll(bunchCarModels);
    }

    public int countCarModels() {
        return carModels.size();
    }

    /**
     *
     * @return total amount of car available in car park
     */
    public int getParkSize() {
        return carPark.size();
    }
}
