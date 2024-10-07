package school.faang.BJS2_32568_CachingCaching;

public class WeatherRemoteService {
    private static final double MIN_TEMPERATURE = -30;
    private static final double MAX_TEMPERATURE = 30;
    private static final double MIN_HUMIDITY = 20;
    private static final double MAX_HUMIDITY = 80;

    public WeatherData getCityWeather(String city) {
        double temperature = MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * Math.random();
        double humidity = MIN_HUMIDITY + (MAX_HUMIDITY - MIN_HUMIDITY) * Math.random();
        return new WeatherData(city, temperature, humidity);
    }
}
