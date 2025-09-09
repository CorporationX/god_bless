package school.faang.cash.cash;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    public WeatherData fetchWeatherData(String city) {
        double minTemp = -10.0;
        double maxTemp = 35.0;
        double temperature = Math
                .round((minTemp + (maxTemp - minTemp) * random.nextDouble()) * 10.0) / 10.0;

        double minHumidity = 10;
        double maxHumidity = 100;
        double humidity = Math
                .round(minHumidity + (maxHumidity - minHumidity) * random.nextDouble());

        return new WeatherData(city, temperature, humidity, System.currentTimeMillis());
    }
}
