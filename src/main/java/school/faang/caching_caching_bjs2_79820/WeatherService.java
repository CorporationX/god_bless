package school.faang.caching_caching_bjs2_79820;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        Random rnd = new Random();
        double temperature = rnd.nextDouble(0, 30);
        double humidity = rnd.nextDouble(0, 100);
        return new WeatherData(city, temperature, humidity);
    }
}
