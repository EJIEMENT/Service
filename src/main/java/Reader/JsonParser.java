package Reader;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import controller.DeleteHumanError;
import human.Human;
import org.springframework.http.HttpStatus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonParser {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public static void converterFromJsonToClass(String filePath) throws IOException {
        Human human = objectMapper.readValue(new File(filePath), Human.class);
        System.out.println(human);

    }

    public static void converterFromClassToJson(Human human, String filePath) throws IOException {
        List<Human> allHumans = getHumans(filePath);
        allHumans.add(human);
        writeHumans(allHumans, filePath);
//        String carAsString = objectMapper.writeValueAsString(human);
//        objectMapper.writeValue(new File(filePath), human);
    }

    public static List<Human> getHumans(String filePath) throws IOException {
        CollectionType javaType = objectMapper.getTypeFactory()
                .constructCollectionType(List.class, Human.class);
        List<Human> asList = objectMapper.readValue(new File(filePath), javaType);
        return asList;
    }

    public static void writeHumans(List<Human> humans, String filePath) throws IOException {
        String jsonArray = objectMapper.writeValueAsString(humans);
        objectMapper.writeValue(new File(filePath), humans);

    }

    public static DeleteHumanError deleteHumans(String surname, String filePath) throws IOException {
        List<Human> humans = getHumans(filePath);
        List<Human> deleteHumans = humans.stream().filter(human -> human.surname.equals(surname)).collect(Collectors.toList());
        if (deleteHumans.isEmpty())
            return new DeleteHumanError(HttpStatus.NOT_FOUND, "not find Humans with such surname", new ArrayList<>());
        else if (deleteHumans.size() > 1)
            return new DeleteHumanError(HttpStatus.CONFLICT, "find few Humans with such surname, please delete Human by ID", deleteHumans);
        else {
            writeHumans(humans.stream().filter(human -> !human.surname.equals(surname)).collect(Collectors.toList()), filePath);
            return new DeleteHumanError(HttpStatus.OK, "Human was deleted", deleteHumans);
        }
    }

    public static int getMaxID(String filePath) throws IOException {
        List<Human> humans = getHumans(filePath);
        return humans.stream().map(Human::getId).max(Integer::compare).get();
    }
    public static DeleteHumanError deleteHumans(int id, String filePath) throws IOException {
        List<Human> humans = getHumans(filePath);
        List<Human> deleteHumans = humans.stream().filter(human -> human.id==(id)).collect(Collectors.toList());
        if (deleteHumans.isEmpty())
            return new DeleteHumanError(HttpStatus.NOT_FOUND, "not find Humans with such id", new ArrayList<>());
        else {
            writeHumans(humans.stream().filter(human -> human.id!=(id)).collect(Collectors.toList()), filePath);
            return new DeleteHumanError(HttpStatus.OK, "Human was deleted", deleteHumans);
        }
    }



}
