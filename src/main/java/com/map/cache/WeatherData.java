package com.map.cache;

import lombok.*;

@Data
public class WeatherData {
    private String city;
    private int temperature;
    private double humidity;

    public WeatherData(String city, int temperature, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
