package school.faang.sprint_1.task_44895;

public class Main {
    public static void main(String[] args) {
        final StandardWeatherCache standardWeatherCache = new StandardWeatherCache();
        final FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();

        System.out.println("Adding Weather data...");
        standardWeatherCache.getWeatherData("Don", 1);
        System.out.println("Printing Weather data...");
        System.out.println(WeatherCacheTemplate.cache);

        System.out.println("Adding Weather data...");
        standardWeatherCache.getWeatherData("Don", 1);
        System.out.println("Printing Weather data...");
        System.out.println(WeatherCacheTemplate.cache);

        standardWeatherCache.forceUpdateWeather("Don");
        System.out.println("Printing Weather data...");
        System.out.println(WeatherCacheTemplate.cache);

        System.out.println("Adding Weather data with frequency method...");
        frequentUpdateWeatherCache.getWeatherData("Don", 1);
        System.out.println("Printing Weather data...");
        System.out.println(WeatherCacheTemplate.cache);


        System.out.println("Removing expired caches...");
        standardWeatherCache.clearExpiredCache(0);
        System.out.println("Printing Weather data...");
        System.out.println(WeatherCacheTemplate.cache);


    }
}
