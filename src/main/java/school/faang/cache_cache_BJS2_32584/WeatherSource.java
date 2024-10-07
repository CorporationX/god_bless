package school.faang.cache_cache_BJS2_32584;

public class WeatherSource {

    private static final int MAX_TEMPERATURE = 40;
    private static final int MAX_HUMIDITY = 90;

    public WeatherData fetchWeather(String city) {
        return new WeatherData(city, Math.round(Math.random() * MAX_TEMPERATURE)
                , Math.round(Math.random() * MAX_HUMIDITY));
    }
}
