package io.shnflrsc.sparky.controller;

import io.shnflrsc.sparky.service.BreedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/breeds")
public class BreedController {

    private final BreedService breedService;

    public BreedController(BreedService breedService) {
        this.breedService = breedService;
    }

    @GetMapping
    public String getRandomBreed() {
        return breedService.getRandomBreed().getBreed();
    }

    @GetMapping("/{count}")
    public List<String> getRandomBreeds(@PathVariable int count) {
        return breedService.getRandomBreeds(count);
    }
}
