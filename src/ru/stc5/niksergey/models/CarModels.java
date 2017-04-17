package ru.stc5.niksergey.models;

import ru.stc5.niksergey.models.xjc.CarModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement
public class CarModels {
    private Set<CarModel> models;

    @XmlElementWrapper(name = "carModelsList")
    @XmlElement(name = "carModel")
    public Set<CarModel> getCarModels() {
        return models;
    }

    public void setCarModels(Set<CarModel> models) {
        this.models = models;
    }
}
