package ru.stc5.niksergey.models;

import ru.stc5.niksergey.models.xjc.Car;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class Cars {
    private Set<Car> cars = new HashSet<>();

    @XmlElementWrapper(name = "carsList")
    @XmlElement(name = "car")
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
