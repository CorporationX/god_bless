package school.faang.weathercache;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final double MIN_TEMP = -30.0;
    private static final double MAX_TEMP = 30.0;
    private static final double MAX_HUMIDITY = 100.0;

    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();

        double temperature = MIN_TEMP + (MAX_TEMP - MIN_TEMP) * random.nextDouble();
        double humidity = random.nextDouble() * MAX_HUMIDITY;
        long timeStamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timeStamp);
    }
}
