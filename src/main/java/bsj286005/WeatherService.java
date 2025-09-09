package bsj286005;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        double randomTemp = ThreadLocalRandom.current().nextDouble(-10.00, 25.9);
        double randomHumidity = ThreadLocalRandom.current().nextDouble(10.00, 99.9);
        return new WeatherData(city, randomTemp, randomHumidity, System.currentTimeMillis());
    }
}