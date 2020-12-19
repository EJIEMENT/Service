package Reader;

import human.Human;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParser {
    public static void convertObjectToXml(Human human, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Human.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(human, new File(filePath));
        } catch (JAXBException e) {

            e.printStackTrace();
        }
    }
    public static Human fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Human.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Human) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
