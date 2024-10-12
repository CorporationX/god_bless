package school.faang.caching;

public class WeatherDateService {
    public WeatherData fetchWeather(String city) {
        double temperature = Math.random() * 30;
        double humidity = Math.random() * 100;
        return new WeatherData(city, temperature, humidity);
    }
}
