package school.faang.main_code;

import lombok.Data;

@Data
public class WeatherService {
    WeatherData weatherData;
    public WeatherData getWeatherData(String name) {
        return new WeatherData(name, Math.random() * 10, Math.random() * 10);
    }
}
