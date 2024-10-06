package school.faang.main_code_cash_cash;

import lombok.Data;

@Data
public class WeatherService {
    public WeatherData getWeatherData(String city) {
        double temperature = Math.random() * 30;
        double humidity = Math.random() * 100;
        return new WeatherData(city, temperature, humidity);
    }
}
