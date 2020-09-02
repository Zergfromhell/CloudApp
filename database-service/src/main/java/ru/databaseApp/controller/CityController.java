package ru.databaseApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.databaseApp.repository.CityRepository;

@RestController
@RequestMapping("/database")
public class CityController {
    private CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/search/{id}")
    public String autoName(@PathVariable(name = "id") String id) {

        return cityRepository.getCityByKladr_id(id).toString();
    }
}
