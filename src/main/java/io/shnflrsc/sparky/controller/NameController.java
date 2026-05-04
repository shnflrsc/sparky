package io.shnflrsc.sparky.controller;

import io.shnflrsc.sparky.service.NameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/names")
public class NameController {

    private final NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @RequestMapping
    public ResponseEntity<String> getRandomName() {
        return ResponseEntity.ok(nameService.getRandomName());
    }

    @RequestMapping("/{count}")
    public ResponseEntity<List<String>> getRandomNames(@PathVariable int count) {
        return ResponseEntity.ok(nameService.getRandomNames(count));
    }
}
