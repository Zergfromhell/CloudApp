package ru.dadataApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dadataApp.repository.DadataRepository;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

@Service
public class DadataService {
    DadataRepository dadataRepository;

    @Autowired
    public DadataService(DadataRepository dadataRepository) {
        this.dadataRepository = dadataRepository;
    }

    public String displayReturnedRequest(String url) throws IOException {
        HttpURLConnection conn = dadataRepository.getHttpURLConnection(url);

        String line;
        int HttpResult = conn.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = conn.getInputStream();
            line = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } else {
            line = conn.getResponseMessage();
        }
        return line;
    }
}
