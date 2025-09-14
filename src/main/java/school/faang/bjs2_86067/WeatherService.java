package school.faang.bjs2_86067;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private static final Random RANDOM = new Random();

    public WeatherData fetchWeatherData(City city) {
        return new WeatherData(
                city,
                RANDOM.nextDouble(-10, 25),
                RANDOM.nextDouble(30, 50),
                System.currentTimeMillis()
        );
    }
}