package school.faang.sprint1.task_44289;

public class StandardWeatherCache extends WeatherCacheTemplate {


    @Override
    public WeatherData fetchWeatherData(String city) {
        long timeInMillis = 60 * 1000;
        return getWeatherData(city, timeInMillis);
    }
}
