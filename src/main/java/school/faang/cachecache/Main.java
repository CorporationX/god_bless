package school.faang.cachecache;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache();
        standardWeatherCache.forceUpdateWeather("New York1");
        Thread.sleep(50L);
        standardWeatherCache.forceUpdateWeather("Moscow1");
        Thread.sleep(50L);
        standardWeatherCache.forceUpdateWeather("Paris1");
        Thread.sleep(50L);
        standardWeatherCache.forceUpdateWeather("London1");
        Thread.sleep(50L);
        standardWeatherCache.forceUpdateWeather("Salzburg1");
        standardWeatherCache.print();

        System.out.println(standardWeatherCache.getWeatherData("New York", 10L));
        WeatherCacheTemplate frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();

        frequentUpdateWeatherCache.forceUpdateWeather("Berlin");
        frequentUpdateWeatherCache.getWeatherData("Berlin", 100L);

        standardWeatherCache.clearExpiredCache(100L);
    }
}
