package com.northcoders.demospringbootapp.model;

import java.util.ArrayList;

public record GeocodeResponse(ArrayList<City> results, Float generationtime_ms) {
}
