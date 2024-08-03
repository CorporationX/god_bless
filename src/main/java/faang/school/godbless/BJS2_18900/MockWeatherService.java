package faang.school.godbless.BJS2_18900;

import lombok.Data;

import java.util.Random;

@Data
public class MockWeatherService {
    private Random random = new Random();
    public WeatherData getWeather(String city) {
        double temperature = -10 + (40 - (-10)) * random.nextDouble();
        double humidity = 10 + (100 - 10) * random.nextDouble();
        temperature = Math.round(temperature * 10.0) / 10.0;
        humidity = Math.round(humidity * 10.0) / 10.0;
        return new WeatherData(city, temperature, humidity);
    }
}
