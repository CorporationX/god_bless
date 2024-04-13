package caching;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;
}
