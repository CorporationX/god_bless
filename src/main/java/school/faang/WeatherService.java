package school.faang;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final double MIN_TEMPERATURE = -50.0;
    private static final double MAX_TEMPERATURE = 30.0;
    private static final double MIN_NUMIDITY = 40.0;
    private static final double MAX_HUMIDITY = 100.0;

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = generateRandomTemperature();
        double humidity = generateRandomHumidity();
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }

    private double generateRandomTemperature() {
        Random random = new Random();
        return MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * random.nextDouble();
    }

    private double generateRandomHumidity() {
        Random random = new Random();
        return MIN_NUMIDITY + (MAX_HUMIDITY - MIN_NUMIDITY) * random.nextDouble();
    }
}
