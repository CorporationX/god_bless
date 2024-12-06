package school.faang.caching_caching;

public class WeatherService implements WeatherProvider{
    private static final double MIN_TEMP = 0;
    private static final double MAX_TEMP = 40;
    private static final double MIN_HUMIDITY = 30;
    private static final double MAX_HUMIDITY = 80;

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, generateTemp(), generateHumidity(), System.currentTimeMillis());
    }
    private double generateTemp() {
        return MIN_TEMP + Math.random() * MAX_TEMP;
    }
    private double generateHumidity() {
        return MIN_HUMIDITY + Math.random() * MAX_HUMIDITY;
    }
}
