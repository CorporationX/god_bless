package school.faang.sprint1.task_44289;

public class StandardWeatherCache extends WeatherCacheTemplate {

    private static final int TIME_IN_MILLIS_VALUE = 1000 * 60;

    @Override
    public WeatherData fetchWeatherData(String city) {
        return getWeatherData(city, TIME_IN_MILLIS_VALUE);
    }
}
