package faang.school.godbless.caching;

import java.util.Random;

public class MockWeatherService {
    public WeatherData fetchWeather(String city) {
        Random random = new Random();
        double temperature = -10 + (40 - (-10)) * random.nextDouble();
        int humidity = random.nextInt(90 - 10 + 1) + 10;
        return new WeatherData(city, temperature, humidity);
    }
}
