package item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


@RestController
public class ItemController {
    JSONParser jsonParser = new JSONParser();
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    ResponseEntity<Object> getItems() {
        try {
            FileReader reader = new FileReader("resources/json/item.json");
            Object items = jsonParser.parse(reader);
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(new Object(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ParseException e) {
            return new ResponseEntity<>(new Object(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}