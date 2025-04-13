package school.faang.cachingweather;

public class WeatherService implements WeatherProvider {
    public final static int MIN_TEMPERATURE = -40;
    public final static int MAX_TEMPERATURE = 40;
    public final static int MIN_HUMIDITY = 0;
    public final static int MAX_HUMIDITY = 80;

    @Override
    public WeatherData fetchWeatherData(String city) {
        WeatherData weatherData = new WeatherData();
        weatherData.setTimestamp(System.currentTimeMillis());
        weatherData.setTemperature((int) Math.random() * (MAX_TEMPERATURE - MIN_TEMPERATURE) + MIN_TEMPERATURE);
        weatherData.setHumidity((int) Math.random() * (MAX_HUMIDITY - MIN_HUMIDITY));
        return weatherData;
    }
}
