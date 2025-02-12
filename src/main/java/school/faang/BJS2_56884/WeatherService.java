package school.faang.BJS2_56884;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private static final double MIN_TEMP = -30;
    private static final double MAX_TEMP = 50;
    private static final double MIN_HUMIDITY = 0;
    private static final double MAX_HUMIDITY = 100;
    private static final Random RANDOM = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        WeatherData data = new WeatherData(city);
        data.setTemperature(calculateTemperature());
        data.setHumidity(calculateHumidity());
        data.setTimestamp(System.currentTimeMillis());
        return data;
    }

    private double calculateTemperature() {
        return MIN_TEMP + (MAX_TEMP - MIN_TEMP) * RANDOM.nextDouble();
    }

    private double calculateHumidity() {
        return MIN_HUMIDITY + (MAX_HUMIDITY - MIN_HUMIDITY) * RANDOM.nextDouble();
    }
}
