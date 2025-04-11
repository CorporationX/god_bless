package school.faang.bjs2_68842;

import java.util.concurrent.ThreadLocalRandom;

import static school.faang.bjs2_68842.WeatherProperty.MAX_HUMIDITY;
import static school.faang.bjs2_68842.WeatherProperty.MAX_MIN_TEMPERATURE;
import static school.faang.bjs2_68842.WeatherProperty.MIN_HUMIDITY;
import static school.faang.bjs2_68842.WeatherProperty.MIN_TEMPERATURE;

public class WeatherService implements WeatherServiceImpl {
    @Override
    public WeatherData fetchWeatherData(City city) {
        double temperature = generateRandom(MIN_TEMPERATURE, MAX_MIN_TEMPERATURE);
        double humidity = generateRandom(MIN_HUMIDITY, MAX_HUMIDITY);
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }

    private double generateRandom(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }
}
