package ru.stc5.niksergey.models;

import ru.stc5.niksergey.models.xjc.Leaser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement
public class Leasers {
    private Set<Leaser> leasers;

    @XmlElementWrapper(name = "leasersList")
    @XmlElement(name = "leaser")
    public Set<Leaser> getLeasers() {
        return leasers;
    }

    public void setLeasers(Set<Leaser> leasers) {
        this.leasers = leasers;
    }
}
