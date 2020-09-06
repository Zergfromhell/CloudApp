package ru.databaseApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "postal_code")
    private Integer postal_code;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "federal_district")
    private String federal_district;

    @Column(name = "region_type")
    private String region_type;

    @Column(name = "region")
    private String region;

    @Column(name = "area_type")
    private String area_type;

    @Column(name = "area")
    private String area;

    @Column(name = "city_type")
    private String city_type;

    @Column(name = "city")
    private String city;

    @Column(name = "settlement_type")
    private String settlement_type;

    @Column(name = "settlement")
    private String settlement;

    @Column(name = "kladr_id")
    private String kladr_id;

    @Column(name = "fias_id")
    private String fias_id;

    @Column(name = "fias_level")
    private String fias_level;

    @Column(name = "capital_marker")
    private Integer capital_marker;

    @Column(name = "okato")
    private String okato;

    @Column(name = "oktmo")
    private String oktmo;

    @Column(name = "tax_office")
    private String tax_office;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "geo_lat")
    private String geo_lat;

    @Column(name = "geo_lon")
    private String geo_lon;

    @Column(name = "population")
    private String population;

    @Column(name = "foundation_year")
    private String foundation_year;

}
