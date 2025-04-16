package school.faang.bjs2_69933;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(
                city,
                ThreadLocalRandom.current().nextInt(-5, 29),
                ThreadLocalRandom.current().nextInt(60, 90),
                System.currentTimeMillis()
        );
    }
}
