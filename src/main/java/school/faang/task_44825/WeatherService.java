package school.faang.task_44825;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final Random RANDOM = new Random();
    private static final double MAX_TEMPERATURE = 50;
    private static final double MIN_TEMPERATURE = -50;
    private static final int NUMBER_SIGN = RANDOM.nextBoolean() ? 1 : -1;
    private static final int MIN_HUMIDITY = 0;
    private static final int MAX_HUMIDITY = 100;

    @Override
    public WeatherData fetchWeatherData(String city) {
        if (city == null) {
            throw new IllegalArgumentException("City doesn't exist");
        }
        double temperature = RANDOM.nextDouble(((MAX_TEMPERATURE - MIN_TEMPERATURE + 1) + MIN_TEMPERATURE))
                * NUMBER_SIGN;
        double humidity = RANDOM.nextDouble((MAX_HUMIDITY - MIN_HUMIDITY) + 1);
        return new WeatherData(city, temperature, humidity, System.currentTimeMillis());
    }
}