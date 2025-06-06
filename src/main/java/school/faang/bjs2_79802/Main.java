package school.faang.bjs2_79802;

public class Main {
    public static void main(String[] args) {
        WeatherCacheTemplate standardCache = new StandardWeatherCache();
        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache();

        System.out.println(frequentCache.getWeatherData("Moskov", 10000));
        System.out.println(frequentCache.getWeatherData("Moskov", 10000));
        System.out.println(frequentCache.getWeatherData("Moskov", 0));
        System.out.println(standardCache.getWeatherData("Moskov", 10000));
        System.out.println(standardCache.getWeatherData("Moskov", 10000));
        System.out.println(standardCache.getWeatherData("Moskov", 0));
        System.out.println(standardCache.getWeatherData("Moskov", 10));
    }
}
