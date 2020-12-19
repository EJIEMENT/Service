package controller;

import Reader.JsonParser;
import human.Human;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HumanController extends Controller {
    String filepath = "src/main/resources/NewHuman.json";

    @GetMapping("/getHumans")
    public ResponseEntity<List<Human>> getHumans() {
        List<Human> humans1 = new ArrayList<>();
        try {
            humans1 = JsonParser.getHumans(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(humans1, HttpStatus.OK);
    }

    @PostMapping("/createHuman")
    ResponseEntity<Human> postHuman(@RequestBody Human newHuman) {
        try {
            newHuman.id = JsonParser.getMaxID(filepath)+1;
            JsonParser.converterFromClassToJson(newHuman, filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(newHuman, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteHuman")
    public ResponseEntity<DeleteHumanError> deleteHuman(@RequestParam(value = "surname") String surname) throws IOException {
        DeleteHumanError response = JsonParser.deleteHumans(surname, filepath);
        return new ResponseEntity<>(response, response.getStatus());
    }
    @DeleteMapping("/deleteHumanById")
    public ResponseEntity<DeleteHumanError> deleteHumanById (@RequestParam(value = "id") int id) throws IOException {
        DeleteHumanError response = JsonParser.deleteHumans(id, filepath);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
