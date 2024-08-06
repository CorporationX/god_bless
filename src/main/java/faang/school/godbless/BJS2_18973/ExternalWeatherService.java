package faang.school.godbless.BJS2_18973;

import java.util.Random;

public class ExternalWeatherService {
    private static final String REQUEST_MESSAGE = "Request weather data from external service";
    private static final int MIN_TEMPERATURE = -40;
    private static final int MAX_TEMPERATURE = 50;
    private static final int MIN_HUMIDITY = 30;
    private static final int MAX_HUMIDITY = 70;

    private double generateTemperature() {
        Random random = new Random();
        return (MIN_TEMPERATURE + random.nextInt(MAX_TEMPERATURE - MIN_TEMPERATURE));
    }

    private double generateHumidity() {
        Random random = new Random();
        return MIN_HUMIDITY + random.nextInt(MAX_HUMIDITY - MIN_HUMIDITY);
    }

    public WeatherData requestWeatherData(String city) {
        System.out.println(REQUEST_MESSAGE);
        return new WeatherData(city, generateTemperature(), generateHumidity());
    }
}
