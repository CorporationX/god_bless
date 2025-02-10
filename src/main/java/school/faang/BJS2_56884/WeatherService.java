package school.faang.BJS2_56884;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private static final double MIN_TEMP = -30;
    private static final double MAX_TEMP = 50;
    private static final double MIN_HUMIDITY = 0;
    private static final double MAX_HUMIDITY = 100;

    private final long timestamp = System.currentTimeMillis();

    @Override
    public WeatherData fetchWeatherData(String city) {
        WeatherData weatherData = new WeatherData(city);
        Random random = new Random();
        double temperature = MIN_TEMP + (MAX_TEMP - MIN_TEMP) * random.nextDouble();
        double humidity = MIN_HUMIDITY + (MAX_HUMIDITY - MIN_HUMIDITY) * random.nextDouble();
        weatherData.setTemperature(temperature);
        weatherData.setHumidity(humidity);
        weatherData.setTimestamp(timestamp);
        return new WeatherData(city);
    }
}
