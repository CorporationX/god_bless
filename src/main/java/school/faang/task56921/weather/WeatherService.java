package school.faang.task56921.weather;

import java.util.Date;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = Math.random() * 100 - 50;
        double humidity = Math.random() * 100;
        long timestamp = new Date().getTime();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
