package WeatherCache;

import lombok.Getter;

@Getter
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;

    public WeatherData(String city, double temperature, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = System.currentTimeMillis();
    }
}