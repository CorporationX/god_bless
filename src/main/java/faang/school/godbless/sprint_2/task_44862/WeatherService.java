package faang.school.godbless.sprint_2.task_44862;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, random.nextDouble(39), random.nextDouble(60), System.currentTimeMillis());
    }
}
