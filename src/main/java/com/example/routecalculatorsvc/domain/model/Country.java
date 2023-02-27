package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class Country {

    Name name;
    List<String> tld;
    String cca2;
    String ccn3;
    String cca3;
    String area;
    String cioc;
    boolean independent;
    String status;
    boolean unMember;
    Currencies currencies;
    IDD idd;
    List<String> capital;
    List<String> altSpellings;
    String region;
    String flag;
    String subregion;
    Languages languages;
    Demonyms demonyms;
    Translations translations;
    List<Double> latlng;
    boolean landlocked;
    List<String> borders;

    @JsonCreator
    public Country(@JsonProperty ("name") Name name,
                   @JsonProperty ("tld") List<String> tld,
                   @JsonProperty ("cca2") String cca2,
                   @JsonProperty ("ccn3") String ccn3,
                   @JsonProperty ("cca3") String cca3,
                   @JsonProperty ("area") String area,
                   @JsonProperty ("cioc") String cioc,
                   @JsonProperty ("independent") boolean independent,
                   @JsonProperty ("status") String status,
                   @JsonProperty ("unMember") boolean unMember,
                   @JsonProperty ("currencies") Currencies currencies,
                   @JsonProperty ("idd") IDD idd,
                   @JsonProperty ("capital") List<String> capital,
                   @JsonProperty ("altSpellings") List<String> altSpellings,
                   @JsonProperty ("region") String region,
                   @JsonProperty ("flag") String flag,
                   @JsonProperty ("subregion") String subregion,
                   @JsonProperty ("languages") Languages languages,
                   @JsonProperty ("demonyms") Demonyms demonyms,
                   @JsonProperty ("translations") Translations translations,
                   @JsonProperty ("latlng") List<Double> latlng,
                   @JsonProperty ("landlocked") boolean landlocked,
                   @JsonProperty ("borders") List<String> borders) {
        this.name = name;
        this.tld = tld;
        this.cca2 = cca2;
        this.ccn3 = ccn3;
        this.cca3 = cca3;
        this.area = area;
        this.cioc = cioc;
        this.independent = independent;
        this.status = status;
        this.unMember = unMember;
        this.currencies = currencies;
        this.idd = idd;
        this.capital = capital;
        this.altSpellings = altSpellings;
        this.region = region;
        this.flag = flag;
        this.subregion = subregion;
        this.languages = languages;
        this.demonyms = demonyms;
        this.translations = translations;
        this.latlng = latlng;
        this.landlocked = landlocked;
        this.borders = borders;
    }
}
