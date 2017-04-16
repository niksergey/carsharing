package ru.stc5.niksergey;

import ru.stc5.niksergey.models.xjc.CarModelType;
import ru.stc5.niksergey.models.xjc.GearType;
import ru.stc5.niksergey.models.xjc.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        ObjectFactory objectFactory = new ObjectFactory();
        CarModelType solarisComfort = objectFactory.createCarModelType();
        solarisComfort.setManufacturer("KIA");
        solarisComfort.setModel("Solaris");
        solarisComfort.setGear(GearType.AUTOMATIC);
        solarisComfort.setPower(120);


        try {
            File file = new File("xmlFiles/solaris.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(CarModelType.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(solarisComfort, file);
            jaxbMarshaller.marshal(solarisComfort, System.out);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            CarModelType solarisUnm = (CarModelType) jaxbUnmarshaller.unmarshal(file);
            System.out.println(solarisUnm);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
