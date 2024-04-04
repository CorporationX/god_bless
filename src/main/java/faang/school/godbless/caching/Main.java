package faang.school.godbless.caching;

public class Main {
    public static void main(String[] args) {
        WeatherCache weatherCache = new WeatherCache();

        weatherCache.showWeather("city");

        weatherCache.updateWeatherCache(new WeatherData("Moscow", 18, 40));
        weatherCache.updateWeatherCache(new WeatherData("London", 15, 60));
        weatherCache.updateWeatherCache(new WeatherData("Paris", 20, 50));
        weatherCache.updateWeatherCache(new WeatherData("Istanbul", 25, 60));

        weatherCache.deleteWeatherCache("Istanbul");

        weatherCache.showAvailableCityCache();
    }
}
