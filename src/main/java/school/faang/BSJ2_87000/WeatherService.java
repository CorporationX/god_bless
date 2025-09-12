package school.faang.BSJ2_87000;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        double randomTemperatureValue = new Random().nextDouble(-30, 50);
        double randomHumidityValue = new Random().nextDouble(15, 90);
        return new WeatherData(city,
                randomTemperatureValue,
                randomHumidityValue,
                System.currentTimeMillis());
    }
}
