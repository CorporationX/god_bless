package school.faang.task_44837;

public class Main {
    public static void main(String[] args) {
        WeatherProvider provider = new WeatherService();
        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);
        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);

        String city = "Москва";
        System.out.println("Стандартный кэш: " + standardCache.getWeatherData(city, 10_000));
        System.out.println("Постоянное обновление: " + frequentCache.getWeatherData(city, 10_000));
    }
}
