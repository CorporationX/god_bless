package school.faang;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double temperature = -60 + (120 * random.nextDouble());
        double humidity = (100.0 * random.nextDouble());
        long currentTime = System.currentTimeMillis() - (5 + random.nextInt(11));
        return new WeatherData(city, currentTime, humidity, temperature);
    }
}
