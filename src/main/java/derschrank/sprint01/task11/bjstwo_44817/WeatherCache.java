package derschrank.sprint01.task11.bjstwo_44817;

public interface WeatherCache {

    WeatherData getWeatherData(String city);

    WeatherData getWeatherData(String city, long maxCacheAgeMillis);
}
