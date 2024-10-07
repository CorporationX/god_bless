package school.faang.cache_cache_BJS2_32584;

public class WeatherSource {

    public WeatherData fetchWeather(String city) {
        return new WeatherData(city, Math.round(Math.random() * 40), Math.round(Math.random() * 90));
    }
}
