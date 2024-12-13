package school.faang.bjs44852;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    static final double MIN_TEMPERATURE = -20.0;
    static final double MAX_TEMPERATURE = 40.0;

    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double temperature = MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * random.nextDouble();
        double humidity = random.nextDouble();

        return new WeatherData(city, temperature, humidity, System.currentTimeMillis());
    }
}
