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
    private Integer postalCode;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "federal_district")
    private String federalDistrict;

    @Column(name = "region_type")
    private String regionType;

    @Column(name = "region")
    private String region;

    @Column(name = "area_type")
    private String areaType;

    @Column(name = "area")
    private String area;

    @Column(name = "city_type")
    private String cityType;

    @Column(name = "city")
    private String city;

    @Column(name = "settlement_type")
    private String settlementType;

    @Column(name = "settlement")
    private String settlement;

    @Column(name = "kladr_id")
    private String kladrId;

    @Column(name = "fias_id")
    private String fiasId;

    @Column(name = "fias_level")
    private String fiasLevel;

    @Column(name = "capital_marker")
    private Integer capitalMarker;

    @Column(name = "okato")
    private String okato;

    @Column(name = "oktmo")
    private String oktmo;

    @Column(name = "tax_office")
    private String taxOffice;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "geo_lat")
    private String geoLat;

    @Column(name = "geo_lon")
    private String geoLon;

    @Column(name = "population")
    private String population;

    @Column(name = "foundation_year")
    private String foundationYear;

}
