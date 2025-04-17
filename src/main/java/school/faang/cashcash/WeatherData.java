package school.faang.cashcash;

import lombok.Data;

@Data
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;

    public WeatherData(String city, double temperature, double humidity, long timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }
}
