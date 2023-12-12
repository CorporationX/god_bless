package CacheCacheWeather;

public class MeteoStation {
    public static WeatherData getWeather(String city) {
        int temperature = (int) (Math.random() * 100);
        int humidity = (int) (Math.random() * 100);

        return new WeatherData(city, temperature, humidity);
    }
}
