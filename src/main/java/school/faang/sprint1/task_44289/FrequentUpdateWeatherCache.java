package school.faang.sprint1.task_44289;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate{

    @Override
    public WeatherData fetchWeatherData(String city) {
        long timeInMillis = 2 * 1000;
        return getWeatherData(city, timeInMillis);
    }
}
