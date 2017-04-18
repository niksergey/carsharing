package local;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import ru.stc5.niksergey.models.CarModels;
import ru.stc5.niksergey.models.Cars;
import ru.stc5.niksergey.models.Leasers;
import ru.stc5.niksergey.models.Rents;
import ru.stc5.niksergey.models.xjc.Leaser;
import ru.stc5.niksergey.utils.DatabaseManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    static {
        DOMConfigurator.configure("fileLog.xml");
    }

    private final static Logger LOGGER = Logger.getLogger(Main.class);


    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
//        databaseManager.clearDatabase();
        downloadFromDataBase(databaseManager);

//        uploadToDataBase(databaseManager);
    }

    private static void downloadFromDataBase(DatabaseManager dbm) {
        Cars park = new Cars();
        park.setCars(dbm.getCars());
        marshall(park, "xmlFiles/cars.xml");

        Rents history = new Rents();
        history.setRents(dbm.getRents());
        marshall(history, "xmlFiles/rents.xml");

        CarModels catalog = new CarModels();
        catalog.setCarModels(dbm.getCarModels());
        marshall(catalog, "xmlFiles/carModels.xml");

        Leasers clients = new Leasers();
        clients.setLeasers(dbm.getLeasers());
        marshall(clients, "xmlFiles/leasers.xml");
    }

    private static void uploadToDataBase(DatabaseManager dbm) {
        Leasers unmarshLeasers = new Leasers();
        unmarshLeasers = unmarshall(unmarshLeasers, "xmlFiles/leasers.xml");
        dbm.uploadLeasers(unmarshLeasers.getLeasers());

        CarModels uCarModels = new CarModels();
        uCarModels = unmarshall(uCarModels, "xmlFiles/carModels.xml");
        dbm.uploadCarModels(uCarModels.getCarModels());

        Cars uCars = new Cars();
        uCars = unmarshall(uCars, "xmlFiles/cars.xml");
        dbm.uploadCars(uCars.getCars());

        Rents uRents = new Rents();
        uRents = unmarshall(uRents, "xmlFiles/rents.xml");
        dbm.uploadRents(uRents.getRents());
    }

    private static <T> void marshall(T wrapClass, String fileName) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(wrapClass.getClass());

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(wrapClass, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static <T> T unmarshall(T wrapClassInstance, String fileName) {
        T vals = null;
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(wrapClassInstance.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            vals = (T) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return vals;
    }
}
