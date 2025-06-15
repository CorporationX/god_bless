package school.faang.caching_caching_bjs2_79820;

import lombok.Getter;

@Getter
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;

    public WeatherData(String city, double temperature, double humidity, long timestamp) {
        this.city = city;
        this.humidity = humidity;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }
}
