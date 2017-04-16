package local;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.stc5.niksergey.CarsharingCompany;
import ru.stc5.niksergey.models.CarModel;
import ru.stc5.niksergey.models.Gear;
import ru.stc5.niksergey.xjc.CarModelType;
import ru.stc5.niksergey.xjc.GearType;
import ru.stc5.niksergey.xjc.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    static {
        DOMConfigurator.configure("fileLog.xml");
    }

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        CarsharingCompany innoSharing = new CarsharingCompany();

        CarModel rio = new CarModel("Kia", "rio", Gear.MANUAL, 126);
        DateFormat sf = new SimpleDateFormat("MM-yyyy");
        String dateString = null;
        try {
            dateString = "01-2016";
            Date prodDate = sf.parse(dateString);
            innoSharing.appendCar(rio, "Z94CB41AACR000001", prodDate);
        } catch (ParseException e) {
            LOGGER.warn("Incorrect date string: " + dateString);
        }

        LOGGER.info("Park size: " + innoSharing.getParkSize());
    }

    private static void jaxbPlaying() {
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
