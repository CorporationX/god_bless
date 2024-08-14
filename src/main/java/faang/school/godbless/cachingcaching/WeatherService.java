package faang.school.godbless.cachingcaching;

public class WeatherService {
    public WeatherData getWeather(String city) {
        double temperature = Math.random() * 40;
        double humidity = Math.random() * 100;
        return new WeatherData(city, temperature, humidity);
    }
}