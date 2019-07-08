package pricing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.minidev.json.parser.JSONParser;

import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import net.minidev.json.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class TotalController {

    JSONParser jsonParser = new JSONParser();
    @RequestMapping(value = "/{id}/total", method = RequestMethod.GET)
    ResponseEntity<Double> total(@PathVariable("id") int id,@RequestParam(value="quantity") int quantity) {
        
        try {
            FileReader reader = new FileReader("resources/json/item.json");
            Object items = jsonParser.parse(reader);
            JSONArray itemsList = (JSONArray) items;


            return new ResponseEntity<>(new Double(0), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(new Double(-1), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ParseException e) {
            return new ResponseEntity<>(new Double(-1), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
