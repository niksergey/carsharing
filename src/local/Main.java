package local;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import ru.stc5.niksergey.CarsharingCompany;
import ru.stc5.niksergey.models.CarModels;
import ru.stc5.niksergey.models.Cars;
import ru.stc5.niksergey.models.Leasers;
import ru.stc5.niksergey.models.Rents;
import ru.stc5.niksergey.models.xjc.*;
import ru.stc5.niksergey.utils.DatabaseManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Set;

public class Main {
    static {
        DOMConfigurator.configure("fileLog.xml");
    }

    private final static Logger LOGGER = Logger.getLogger(Main.class);


    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();

        Cars park = new Cars();
        park.setCars(databaseManager.getCars());
        unmarshall(park, "xmlFiles/cars.xml");

        Rents history = new Rents();
        history.setRents(databaseManager.getRents());
        unmarshall(history, "xmlFiles/rents.xml");

        CarModels catalog = new CarModels();
        catalog.setCarModels(databaseManager.getCarModels());
        unmarshall(catalog, "xmlFiles/carModels.xml");

        Leasers clients = new Leasers();
        clients.setLeasers(databaseManager.getLeasers());
        unmarshall(clients, "xmlFiles/leasers.xml");

    }

    private static <T> void unmarshall(T wrapClass, String fileName) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(wrapClass.getClass());

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(wrapClass, file);

//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            CarModel solarisUnm = (CarModel) jaxbUnmarshaller.unmarshal(file);
//            System.out.println(solarisUnm);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
