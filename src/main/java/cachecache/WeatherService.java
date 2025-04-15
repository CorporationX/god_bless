package cachecache;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double newTemperature = random.nextDouble(100);
        double newHumidity = random.nextDouble(100);
        return new WeatherData(city, newTemperature, newHumidity, System.currentTimeMillis());
    }

}
