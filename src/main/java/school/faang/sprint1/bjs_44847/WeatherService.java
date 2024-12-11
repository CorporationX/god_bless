package school.faang.sprint1.bjs_44847;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        return (new WeatherData(city, random.nextDouble(-20, 40),
                random.nextDouble(20, 100), System.currentTimeMillis()));
    }
}
