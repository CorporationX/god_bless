package school.faang.task_44872;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider service = new WeatherService();

        WeatherCacheTemplate standardCache = new StandartWeatherCache(service, 5000);

        String city1 = "Simferopol";

        System.out.println("Standard Cache:");
        System.out.println(standardCache.fetchWeatherData(city1));
        Thread.sleep(3000);
        System.out.println(standardCache.fetchWeatherData(city1));
        Thread.sleep(3000);
        System.out.println(standardCache.fetchWeatherData(city1));

        FrequentUpdateWeatherCache frequentUpdateCache = new FrequentUpdateWeatherCache(service, 2000);

        String city2 = "Moscow";

        System.out.println("\nFrequent Update Cache:");
        System.out.println(frequentUpdateCache.fetchWeatherData(city2));
        Thread.sleep(1000);
        System.out.println(frequentUpdateCache.fetchWeatherData(city2));
        System.out.println(frequentUpdateCache.fetchWeatherData(city2));

        frequentUpdateCache.stopTimer();
    }
}


