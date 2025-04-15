package school.faang.cachecache;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final int RANDOM_60 = 60;
    private static final int RANDOM_30 = 30;
    private static final int RANDOM_20 = 20;

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, new Random().nextInt(RANDOM_60) - RANDOM_30,
                new Random().nextInt(RANDOM_60) + RANDOM_20, System.currentTimeMillis());
    }
}
