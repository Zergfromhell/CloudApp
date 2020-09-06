package ru.databaseApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.databaseApp.model.City;
import ru.databaseApp.repository.DatabaseRepository;

@RestController
@RequestMapping("/database")
public class DatabaseController {
    private DatabaseRepository databaseRepository;

    @Autowired
    public DatabaseController(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @GetMapping("/search/{id}")
    public City getCity(@PathVariable(name = "id") String id) {

        return databaseRepository.getCityByKladr_id(id);
    }
}
