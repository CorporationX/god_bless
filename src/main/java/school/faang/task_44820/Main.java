package school.faang.task_44820;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider provider = new WeatherService();
        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);
        System.out.println(standardCache.getWeatherData("Barcelona", 5000));
        Thread.sleep(6000);
        System.out.println(standardCache.getWeatherData("Barcelona", 5000));
        standardCache.clearExpiredCache(1000);
        Thread.sleep(1);
        System.out.println(standardCache.getWeatherData("Barcelona", 15000));


    }
}
