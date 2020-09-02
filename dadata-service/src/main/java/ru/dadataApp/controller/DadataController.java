package ru.dadataApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dadataApp.service.DadataService;

import java.io.IOException;

@RestController
@RequestMapping("/dadata")
public class DadataController {
    DadataService dadataService;

    @Autowired
    public DadataController(DadataService dadataService) {
        this.dadataService = dadataService;
    }

    @GetMapping("/search/{kladr_id}")
    public String cleanAddress(@PathVariable(name = "kladr_id") String kladr_id) throws IOException {

        String resultRequest = dadataService.displayReturnedRequest(kladr_id);

        return resultRequest;
    }
}
