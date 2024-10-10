package bjs2_29014;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
public class WeatherData {
    private String city;
    private double temperature;
    private int humidity;
}
