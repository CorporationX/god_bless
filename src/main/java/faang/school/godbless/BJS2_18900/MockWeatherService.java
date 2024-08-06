package faang.school.godbless.BJS2_18900;

import lombok.Data;

import java.util.Random;

@Data
public class MockWeatherService {
    private Random random = new Random();
    private static final double MIN_TEMPERATURE = -10.0;
    private static final double MAX_TEMPERATURE = 40.0;
    private static final double MIN_HUMIDITY = 10.0;
    private static final double MAX_HUMIDITY = 100.0;

    public WeatherData getWeather(String city) {
        double temperature = MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * random.nextDouble();
        double humidity = MIN_HUMIDITY + (MAX_HUMIDITY - MIN_HUMIDITY) * random.nextDouble();
        temperature = Math.round(temperature * 10.0) / 10.0;
        humidity = Math.round(humidity * 10.0) / 10.0;
        return new WeatherData(city, temperature, humidity);
    }
}
