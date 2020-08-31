package ru.databaseApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Getter
    @Setter
    @Column(name = "postal_code")
    private Integer postal_code;

    @Getter
    @Setter
    @Column(name = "address")
    private String address;

    @Getter
    @Setter
    @Column(name = "country")
    private String country;

    @Getter
    @Setter
    @Column(name = "federal_district")
    private String federal_district;

    @Getter
    @Setter
    @Column(name = "region_type")
    private String region_type;

    @Getter
    @Setter
    @Column(name = "region")
    private String region;

    @Getter
    @Setter
    @Column(name = "area_type")
    private String area_type;

    @Getter
    @Setter
    @Column(name = "area")
    private String area;

    @Getter
    @Setter
    @Column(name = "city_type")
    private String city_type;

    @Getter
    @Setter
    @Column(name = "city")
    private String city;

    @Getter
    @Setter
    @Column(name = "settlement_type")
    private String settlement_type;

    @Getter
    @Setter
    @Column(name = "settlement")
    private String settlement;

    @Getter
    @Setter
    @Column(name = "kladr_id")
    private String kladr_id;

    @Getter
    @Setter
    @Column(name = "fias_id")
    private String fias_id;

    @Getter
    @Setter
    @Column(name = "fias_level")
    private String fias_level;

    @Getter
    @Setter
    @Column(name = "capital_marker")
    private Integer capital_marker;

    @Getter
    @Setter
    @Column(name = "okato")
    private String okato;

    @Getter
    @Setter
    @Column(name = "oktmo")
    private String oktmo;

    @Getter
    @Setter
    @Column(name = "tax_office")
    private String tax_office;

    @Getter
    @Setter
    @Column(name = "timezone")
    private String timezone;

    @Getter
    @Setter
    @Column(name = "geo_lat")
    private String geo_lat;

    @Getter
    @Setter
    @Column(name = "geo_lon")
    private String geo_lon;

    @Getter
    @Setter
    @Column(name = "population")
    private String population;

    @Getter
    @Setter
    @Column(name = "foundation_year")
    private String foundation_year;

    @Override
    public String toString() {
        return "City{" +
                "postal_code=" + postal_code +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", federal_district='" + federal_district + '\'' +
                ", region_type='" + region_type + '\'' +
                ", region='" + region + '\'' +
                ", area_type='" + area_type + '\'' +
                ", area='" + area + '\'' +
                ", city_type='" + city_type + '\'' +
                ", city='" + city + '\'' +
                ", settlement_type='" + settlement_type + '\'' +
                ", settlement='" + settlement + '\'' +
                ", kladr_id='" + kladr_id + '\'' +
                ", fias_id='" + fias_id + '\'' +
                ", fias_level=" + fias_level +
                ", capital_marker=" + capital_marker +
                ", okato='" + okato + '\'' +
                ", oktmo='" + oktmo + '\'' +
                ", tax_office=" + tax_office +
                ", timezone=" + timezone +
                ", geo_lat='" + geo_lat + '\'' +
                ", geo_lon='" + geo_lon + '\'' +
                ", population=" + population +
                ", foundation_year=" + foundation_year +
                '}';
    }
}
