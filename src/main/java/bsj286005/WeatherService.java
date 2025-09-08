package bsj286005;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        int randomTemp = ThreadLocalRandom.current().nextInt(-10, 25);
        int randomHumidity = ThreadLocalRandom.current().nextInt(10, 90);
        return new WeatherData(city, randomTemp, randomHumidity, System.currentTimeMillis());
    }
}