package school.faang.sprint1.task_44289;

public class StandardWeatherCache extends WeatherCacheTemplate {

    @Override
    public WeatherData fetchWeatherData(String city) {
        return getWeatherData(city, TIME_IN_MILLIS_VALUE);
    }

    private static final int TIME_IN_MILLIS_VALUE = 1000 * 60;
}
