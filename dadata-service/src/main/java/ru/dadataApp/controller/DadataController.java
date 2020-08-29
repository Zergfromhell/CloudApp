package ru.dadataApp.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


@Controller
@RequestMapping("/dadata")
public class DadataController {
    @GetMapping("/search/{id}")
    public String cleanAddress(@PathVariable(name = "id", required = false) String id, Model model) throws IOException {

        String request = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/" + id;

        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Token abda59b74a5dd9c83bc31606b7a3f20d6b0fffb1");
        JSONObject query = new JSONObject();
        query.put("query", "9120b43f-2fae-4838-a144-85e43c2bfb29");

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(query.toString());
        wr.flush();

        //display what returns the POST request
        String line = null;
        int HttpResult = conn.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = conn.getInputStream();
            line = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(line);
        } else {
            System.out.println(conn.getResponseMessage());
        }
        model.addAttribute("resultString", line);
        return "result";
    }
}
