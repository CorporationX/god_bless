package school.faang;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double temperature = -60 + (120 * random.nextDouble());
        double humidity = (100.0 * random.nextDouble());
        int a = 5;
        int b = 15;
        double currentTime = System.currentTimeMillis() - (a + random.nextInt(b - a + 1));
        return new WeatherData(city, currentTime, humidity, temperature);
    }
}
