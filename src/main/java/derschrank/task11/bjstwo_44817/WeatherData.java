package derschrank.task11.bjstwo_44817;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    String city;
    double temperature;
    double humidity;
    long timestamp;

    @Override
    public String toString() {
        return String.format("%s, temp: %3.0f°C, humidity: %3.0f%%", city, temperature, humidity);
    }
}
