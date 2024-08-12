package BJS2_18987;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;

    public WeatherData(String city, double temperature, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
