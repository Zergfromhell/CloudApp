package ru.dadataApp.repository;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository
public class DadataRepository {
    public HttpURLConnection getHttpURLConnection(String kladr_id) throws IOException {
        URL url = new URL("https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/address");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Token abda59b74a5dd9c83bc31606b7a3f20d6b0fffb1");
        JSONObject query = new JSONObject();
        query.put("query", kladr_id);

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(query.toString());
        wr.flush();

        return conn;
    }
}
