package school.faang.task_44818;

import lombok.Getter;

@Getter
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;

    public WeatherData(String city, double temperature, double humidity, long timestamp) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("Город не может быть пустым");
        }
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }
}
