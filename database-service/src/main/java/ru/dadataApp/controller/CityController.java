package ru.dadataApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dadataApp.repository.CityRepository;

@Controller
@RequestMapping("/database")
public class CityController {
    private CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/search/{id}")
    public String autoName(@PathVariable(name = "id", required = false) String id, Model model) {
        model.addAttribute("resultString", cityRepository.getCityByKladr_id(id).toString());

        return "resultDB";
    }
}
