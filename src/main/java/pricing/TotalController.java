package pricing;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.parser.JSONParser;

@RestController
public class TotalController {

    @PostMapping("/total")
    Total total(@RequestParam int quantity, @RequestBody Item item) {
        double total = item.price * quantity;    
        return new Total(total);
    }
}
