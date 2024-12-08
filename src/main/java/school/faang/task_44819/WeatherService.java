package school.faang.task_44819;

import java.sql.Timestamp;
import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double minTemperature = -50;
        double maxTemperature = +50;
        double minHumidity = 0;
        double maxHumidity = 100;
        double temperature = random.nextDouble(maxTemperature - minTemperature) + minTemperature;
        double humidity = random.nextDouble(maxHumidity - minHumidity) + minHumidity;
        return new WeatherData(city, temperature, humidity, new Timestamp(System.currentTimeMillis()).getTime());
    }
}
