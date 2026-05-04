package io.shnflrsc.sparky.service;

import io.shnflrsc.sparky.entity.Breed;
import io.shnflrsc.sparky.repository.BreedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedService {

    private final BreedRepository breedRepository;

    public BreedService(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    public Breed getRandomBreed() {
        return breedRepository.findRandomBreed();
    }

    public List<String> getRandomBreeds(int count) {
        return breedRepository.findRandomBreeds(count).stream().map(Breed::getBreed).toList();
    }
}
