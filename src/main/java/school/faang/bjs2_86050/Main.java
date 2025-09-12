package school.faang.bjs2_86050;

public class Main {
    public static void main(String[] args) {
        WeatherProvider service = new WeatherService();
        WeatherCacheTemplate standardCache = new StandardWeatherCache(service);

        WeatherData d1 = standardCache.getWeatherData("Москва", 3000);
        System.out.printf("%s | %.2f°C | %.1f%% влажность%n",
                d1.getCity(), d1.getTemperature(), d1.getHumidity());

        WeatherData d2 = standardCache.getWeatherData("Сургут", 3000);
        System.out.printf("%s | %.2f°C | %.1f%% влажность%n",
                d2.getCity(), d2.getTemperature(), d2.getHumidity());

        WeatherData d3 = standardCache.getWeatherData("Тюмень", 3000);
        System.out.printf("%s | %.2f°C | %.1f%% влажность%n",
                d3.getCity(), d3.getTemperature(), d3.getHumidity());

        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(service);

        WeatherData d4 = frequentCache.getWeatherData("Питер", 3000);
        System.out.printf("%s | %.2f°C | %.1f%% влажность%n",
                d4.getCity(), d4.getTemperature(), d4.getHumidity());

        WeatherData d5 = frequentCache.getWeatherData("Когалым", 3000);
        System.out.printf("%s | %.2f°C | %.1f%% влажность%n",
                d5.getCity(), d5.getTemperature(), d5.getHumidity());
    }
}
