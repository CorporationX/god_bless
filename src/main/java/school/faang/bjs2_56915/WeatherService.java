package school.faang.bjs2_56915;

import lombok.NonNull;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private static final double MIN_TEMPERATURE = -50;
    private static final double MAX_TEMPERATURE = 50;
    private static final double MIN_HUMIDITY = 0;
    private static final double MAX_HUMIDITY = 100;
    private static final Random RANDOM = new Random();

    @Override
    public WeatherData fetchWeatherData(@NonNull String city) {
        WeatherData data = new WeatherData(city);
        data.setTemperature(calculateTemperature());
        data.setHumidity(calculateHumidity());
        data.setTimestamp(System.currentTimeMillis());
        return data;
    }

    private double calculateTemperature() {
        return RANDOM.nextDouble() * MAX_TEMPERATURE - MIN_TEMPERATURE;
    }

    private double calculateHumidity() {
        return RANDOM.nextDouble() * MAX_HUMIDITY - MIN_HUMIDITY;
    }
}
