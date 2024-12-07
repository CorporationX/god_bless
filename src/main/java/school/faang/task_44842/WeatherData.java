package school.faang.task_44842;

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

    public WeatherData(String name) {
    this.city = name;
    }

    @Override
    public String toString() {
        return "WeatherData{"
                + "city='" + city + '\''
                + ", temperature=" + temperature
                + ", humidity=" + humidity
                +", timestamp=" + timestamp + '}';
    }
}
