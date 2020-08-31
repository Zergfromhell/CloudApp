package ru.dadataApp.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dadataApp.service.DadataService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


@Controller
@RequestMapping("/dadata")
public class DadataController {
    DadataService dadataService;

    @Autowired
    public DadataController(DadataService dadataService) {
        this.dadataService = dadataService;
    }

    @GetMapping("/search/{id}")
    public String cleanAddress(@PathVariable(name = "id", required = false) String id, Model model) throws IOException {

        String resultRequest = dadataService.displayReturnedRequest("https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/" + id);

        model.addAttribute("resultString", resultRequest);
        return "result";
    }
}
