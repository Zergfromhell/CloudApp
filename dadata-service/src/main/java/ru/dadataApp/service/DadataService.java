package ru.dadataApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dadataApp.repository.DadataRepository;

@Service
public class DadataService {
    DadataRepository dadataRepository;

    @Autowired
    public DadataService(DadataRepository dadataRepository) {
        this.dadataRepository = dadataRepository;
    }

    public String displayReturnedRequest(String kladr_id) {

        return dadataRepository.getHttpURLConnection(kladr_id);
    }
}
