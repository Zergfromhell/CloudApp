package ru.dadataApp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.dadataApp.client.DatabaseServiceClient;
import ru.dadataApp.model.City;
import ru.dadataApp.model.SuggestionsContainer;
import ru.dadataApp.repository.DadataRepository;

@Service
public class DadataService {
    private DadataRepository dadataRepository;
    private RefreshEndpoint refreshEndpoint;
    private DatabaseServiceClient client;

    @Autowired
    public DadataService(DadataRepository dadataRepository, RefreshEndpoint refreshEndpoint, DatabaseServiceClient client) {
        this.dadataRepository = dadataRepository;
        this.refreshEndpoint = refreshEndpoint;
        this.client = client;
    }

    public City displayReturnedRequest(String kladr_id) {
        ResponseEntity<String> response = dadataRepository.getResponse(kladr_id);

        if(response.getStatusCode() != HttpStatus.OK) return client.getCity(kladr_id);

        Gson gson = new GsonBuilder().create();

        SuggestionsContainer data = gson.fromJson(response.getBody(), SuggestionsContainer.class);

        return data.getSuggestions().get(0).getData();
    }

    public String refresh() {
        refreshEndpoint.refresh();
        return "Properties are successfully refreshed";
    }
}