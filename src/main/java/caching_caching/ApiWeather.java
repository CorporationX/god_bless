package caching_caching;

public class ApiWeather {
    public WeatherData getWeatherData(String city) {
        return new WeatherData(city, Math.floor(Math.random() * 10), Math.floor(Math.random() * 50));
    }
}
