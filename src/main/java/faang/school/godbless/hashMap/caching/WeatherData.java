package faang.school.godbless.hashMap.caching;

import lombok.Data;

@Data
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public WeatherData(String city, int temperature, int humidity) {
        if (city == null || city.isEmpty() || city.isBlank()) {
            throw new IllegalArgumentException("City can`t be empty");
        }
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "City: " + city + ", temperature: " + temperature + ", humidity: " + humidity;
    }
}
