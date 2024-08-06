package faang.school.godbless.BJS2_18873;

import java.util.Random;

public class WeatherExternalService {

    private final int MIN_TEMPERATURE = 15;
    private final int MAX_TEMPERATURE = 35;
    private final int MIN_HUMIDITY = 50;
    private final int MAX_HUMIDITY = 100;
    Random random = new Random();

    public WeatherData getWeather(String city) {
        int randomTemperature = random.nextInt(MAX_TEMPERATURE - MIN_TEMPERATURE + 1) + MIN_TEMPERATURE;
        int randomHumidity = random.nextInt(MAX_HUMIDITY - MIN_HUMIDITY + 1) + MIN_HUMIDITY;
        return new WeatherData(city, randomTemperature, randomHumidity);
    }
}
