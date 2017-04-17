package ru.stc5.niksergey.models;

import ru.stc5.niksergey.models.xjc.Rent;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * Created by sergey on 17.04.17.
 */
@XmlRootElement
public class Rents {
    private Set<Rent> rents;

    @XmlElementWrapper(name = "rentsList")
    @XmlElement(name = "rent")
    public Set<Rent> getRents() {
        return rents;
    }

    public void setRents(Set<Rent> rents) {
        this.rents = rents;
    }
}
