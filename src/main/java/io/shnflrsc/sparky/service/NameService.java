package io.shnflrsc.sparky.service;

import io.shnflrsc.sparky.entity.Name;
import io.shnflrsc.sparky.repository.NameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameService {

    private final NameRepository nameRepository;

    public NameService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    public String getRandomName() {
        return nameRepository.findRandomName().getName();
    }

    public List<String> getRandomNames(int count) {
        return nameRepository.findRandomNames(count).stream().map(Name::getName).toList();
    }
}
