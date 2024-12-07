package school.faang.task_44839;

public class Main {

    public static void main(String[] args) {
        final WeatherProvider provider = new WeatherService();

        final WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache(provider);
        System.out.println(standardWeatherCache.getWeatherData("City1", 1000));
        System.out.println(standardWeatherCache.getWeatherData("City2", 1000));
        System.out.println("--------------------");

        long currentTime = System.currentTimeMillis();
        WeatherData weatherData = new WeatherData("City3", 0, 50, currentTime);
        System.out.println(standardWeatherCache.isCacheExpired(weatherData, 2000));
        System.out.println("--------------------");

        standardWeatherCache.printAllCacheData();

        standardWeatherCache.clearExpiredCache(1);
        System.out.println("--------------------");

        standardWeatherCache.printAllCacheData();
        System.out.println("--------------------");


        final WeatherCacheTemplate frequentWeatherCache = new FrequentUpdateWeatherCache(provider);
        System.out.println(frequentWeatherCache.getWeatherData("City4", 2000));
        System.out.println(frequentWeatherCache.getWeatherData("City5", 2000));

        System.out.println("--------------------");
        frequentWeatherCache.printAllCacheData();

        System.out.println("--------------------");

        currentTime = System.currentTimeMillis();
        weatherData = new WeatherData("City6", 0, 60, currentTime);
        System.out.println(frequentWeatherCache.isCacheExpired(weatherData, 1000));
    }

}
