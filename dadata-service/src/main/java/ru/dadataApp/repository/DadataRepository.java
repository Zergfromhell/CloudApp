package ru.dadataApp.repository;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.dadataApp.client.DatabaseServiceClient;

@Repository
@RefreshScope
public class DadataRepository {
    @Value("${headers.content-type}")
    private String mediaType;
    @Value("${headers.first-header.name}")
    private String firstHeaderName;
    @Value("${headers.first-header.value}")
    private String firstHeaderValue;
    @Value("${headers.second-header.name}")
    private String secondHeaderName;
    @Value("${headers.second-header.value}")
    private String secondHeaderValue;
    @Value("${url}")
    private String url;
    @Value("${http-method}")
    private String httpMethod;
    @Value("${data}")
    private String data;

    private DatabaseServiceClient client;

    @Autowired
    public DadataRepository(DatabaseServiceClient client) {
        this.client = client;
    }

    public String getHttpURLConnection(String kladr_id) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(mediaType));
        headers.add(firstHeaderName, firstHeaderValue);
        headers.add(secondHeaderName, secondHeaderValue);

        JSONObject request = new JSONObject();
        request.put(data, kladr_id);

        HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.valueOf(httpMethod), entity, String.class);

        if(response.getStatusCode() != HttpStatus.OK) return client.getCity(kladr_id);

        return response.getBody();
    }
}
