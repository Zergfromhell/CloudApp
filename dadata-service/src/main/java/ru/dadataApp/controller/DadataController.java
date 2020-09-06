package ru.dadataApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dadataApp.model.City;
import ru.dadataApp.service.DadataService;

@RestController
@RequestMapping("/search")
public class DadataController {
    private DadataService dadataService;

    @Autowired
    public DadataController(DadataService dadataService) {
        this.dadataService = dadataService;
    }

    @GetMapping("/city/{kladr_id}")
    public City cleanAddress(@PathVariable(name = "kladr_id") String kladr_id) {

        return dadataService.displayReturnedRequest(kladr_id);
    }

    @GetMapping("/config/refresh")
    public String refresh() {

        return dadataService.refresh();
    }
}