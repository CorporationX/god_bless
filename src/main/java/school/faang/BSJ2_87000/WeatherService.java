package school.faang.BSJ2_87000;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final int MIN_TEMPERATURE_VALUE = -30;
    private static final int MAX_TEMPERATURE_VALUE = 50;
    private static final int MIN_HUMIDITY_VALUE = 15;
    private static final int MAX_HUMIDITY_VALUE = 90;

    @Override
    public WeatherData fetchWeatherData(String city) {
        double randomTemperatureValue = new Random().nextDouble(MIN_TEMPERATURE_VALUE, MAX_TEMPERATURE_VALUE);
        double randomHumidityValue = new Random().nextDouble(MIN_HUMIDITY_VALUE, MAX_HUMIDITY_VALUE);
        return new WeatherData(city,
                randomTemperatureValue,
                randomHumidityValue,
                System.currentTimeMillis());
    }
}
