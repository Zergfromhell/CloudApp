package ru.databaseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.databaseApp.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("select c from City c where c.kladr_id=:kladr_id")
    City getCityByKladr_id(@Param("kladr_id") String kladr_id);
}
