package ru.dadataApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.stereotype.Service;
import ru.dadataApp.client.DatabaseServiceClient;
import ru.dadataApp.repository.DadataRepository;

@Service
public class DadataService {
    DadataRepository dadataRepository;
    RefreshEndpoint refreshEndpoint;
    DatabaseServiceClient client;

    @Autowired
    public DadataService(DadataRepository dadataRepository, DatabaseServiceClient client, RefreshEndpoint refreshEndpoint) {
        this.dadataRepository = dadataRepository;
        this.refreshEndpoint = refreshEndpoint;
        this.client = client;
    }

    public String displayReturnedRequest(String kladr_id) {

        return dadataRepository.getHttpURLConnection(kladr_id);
    }

    public String refresh() {
        refreshEndpoint.refresh();
        return "Properties are successfully refreshed";
    }

    public String redirectToDatabase() {

        return client.getCity("0100000200000");
    }
}
