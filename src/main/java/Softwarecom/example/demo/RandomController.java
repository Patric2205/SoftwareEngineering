package Softwarecom.example.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class RandomController {

    @GetMapping("/random")
    public ResponseEntity<Integer> getRandomNumber() {
        int value = ThreadLocalRandom.current().nextInt();
        return ResponseEntity.ok(value);

    }
}
