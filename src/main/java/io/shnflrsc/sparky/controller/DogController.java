package io.shnflrsc.sparky.controller;

import io.shnflrsc.sparky.entity.Dog;
import io.shnflrsc.sparky.service.BreedService;
import io.shnflrsc.sparky.service.NameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private final NameService nameService;
    private final BreedService breedService;

    public DogController(NameService nameService, BreedService breedService) {
        this.nameService = nameService;
        this.breedService = breedService;
    }

    @GetMapping
    public ResponseEntity<Dog> getRandomDog() {
        Dog dog = new Dog(nameService.getRandomName(), breedService.getRandomBreed().getBreed(), (int) (Math.random() * 16));
        return ResponseEntity.ok(new Dog(dog.name(), dog.breed(), dog.age()));
    }

    @GetMapping("/{count}")
    public ResponseEntity<List<Dog>> getRandomDogs(@PathVariable int count) {
        List<Dog> responseDogs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Dog dog = new Dog(nameService.getRandomName(), breedService.getRandomBreed().getBreed(), (int) (Math.random() * 16));
            responseDogs.add(new Dog(dog.name(), dog.breed(), dog.age()));
        }
        return ResponseEntity.ok(responseDogs);
    }
}
