package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.model.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DemoController {

    @GetMapping("/hello")
    public String greeting(){
        return "Hello there!";
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Simon", 18, "simon@northcoders.com", "Liverpool", "Pasta"));
        people.add(new Person("Alex", 17, "alex@northcoders.com", "London", "Burger"));
        return people;
    }

    @GetMapping("/geocode")
    public String getLatLong(@RequestParam String city){
        WebClient webClient = WebClient.create("https://geocoding-api.open-meteo.com");

        GeocodeResponse response = webClient.get()
                .uri("/v1/search?name=" + city + "&count=1&language=en&format=json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GeocodeResponse.class)
                .block();

        if (response == null || response.results() == null) return "City not found!";

        City cityFromWeb = response.results().getFirst();

        return  "city:      " + cityFromWeb.name() + "\n" +
                "latitude:  " + cityFromWeb.latitude() + "\n" +
                "longitude: " + cityFromWeb.longitude() + "\n";
    }

    @GetMapping("/suntimes")
    public String getSunriseSunset(@RequestParam float lat, @RequestParam float lng){
        WebClient webClient = WebClient.create("https://api.sunrisesunset.io");

        SunTimeResponse response = webClient.get()
                .uri("json?lat=" + lat + "&lng=" +lng)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(SunTimeResponse.class)
                .block();

        if (response == null || response.results() == null) return "Sunrise and sunset not found!";

        return "Sunrise: " + response.results().sunrise() + "\n" + "Sunset: " + response.results().sunset();
    }
}
