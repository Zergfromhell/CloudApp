package ru.dadataApp.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.dadataApp.model.City;

@FeignClient("database-service")
public interface DatabaseServiceClient {

    @GetMapping("/database/search/{id}")
    City getCity(@PathVariable(name = "id") String id);
}