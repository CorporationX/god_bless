package faang.school.godbless.cash;

import java.util.Random;

public class WeatherService {
    private static final int MIN_TEMPERATURE = -20;
    private static final int MAX_TEMPERATURE = 31;
    private static final int MIN_HUMIDITY = 20;
    private static final int MAX_HUMIDITY = 60;
    private static final Random random = new Random();

    public static WeatherData getForecast(String city) {
        int temp = random.nextInt(MIN_TEMPERATURE, MAX_TEMPERATURE);
        int humidity = random.nextInt(MIN_HUMIDITY, MAX_HUMIDITY);
        return new WeatherData(city, temp, humidity);
    }
}
