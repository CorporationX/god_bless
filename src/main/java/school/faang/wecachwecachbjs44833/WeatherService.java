package school.faang.wecachwecachbjs44833;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city){
        double temperature = random.nextDouble() * 50;
        double humidity = random.nextDouble() * 100;
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
