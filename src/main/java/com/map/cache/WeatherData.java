package com.map.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Getter
@ToString
@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private double humidity;
}
