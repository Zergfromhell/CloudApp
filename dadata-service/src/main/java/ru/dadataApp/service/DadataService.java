package ru.dadataApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.stereotype.Service;
import ru.dadataApp.client.DatabaseServiceClient;
import ru.dadataApp.repository.DadataRepository;

@Service
public class DadataService {
    private DadataRepository dadataRepository;
    private RefreshEndpoint refreshEndpoint;

    @Autowired
    public DadataService(DadataRepository dadataRepository, RefreshEndpoint refreshEndpoint) {
        this.dadataRepository = dadataRepository;
        this.refreshEndpoint = refreshEndpoint;
    }

    public String displayReturnedRequest(String kladr_id) {

        return dadataRepository.getHttpURLConnection(kladr_id);
    }

    public String refresh() {
        refreshEndpoint.refresh();
        return "Properties are successfully refreshed";
    }
}
