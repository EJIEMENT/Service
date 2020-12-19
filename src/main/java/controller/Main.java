package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class,args);


//        List<Human> humans = new ArrayList<>();
//        Human human = new Human("Oleksii", "Konontsev", 30, new Address("Lviv", "Vel", 14));
//        Human human1 = new Human("Volodya", "Konontsev", 30, new Address("Lviv", "Vel", 14));
//        humans.add(human);
//        humans.add(human1);
//        try {
//
////            JsonParser.converterFromClassToJson(human, "src/main/resources/Human.json");
//            List<Human> humans1 = JsonParser.getHumans("src/main/resources/Human.json");
//            System.out.println(humans1);
//        } catch (FileNotFoundException e) {
//            System.out.println("fie not dound");
//        } catch (IOException e) {
//            System.out.println("Error");
//            e.printStackTrace();
//        }

//        XmlParser.convertObjectToXml(human, "src/main/resources/Human.xml");
//        Human human1 = XmlParser.fromXmlToObject("src/main/resources/Human.xml");
//        System.out.println(human1);
    }
}
