package school.faang.caching;

public class Main {
        public static void main(String[] args) throws InterruptedException {
            WeatherCacheTemplate standardCache = new StandardWeatherCache(new WeatherService());
            WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(new WeatherService());

            System.out.println(frequentCache.getWeatherData("Moskov", 50000));
            System.out.println(frequentCache.getWeatherData("Moskov", 50000));
            System.out.println(frequentCache.getWeatherData("Moskov", 0));
            System.out.println(standardCache.getWeatherData("Moskov", 30000));
            System.out.println(standardCache.getWeatherData("Moskov", 30000));
            System.out.println(standardCache.getWeatherData("Moskov", 0));
            System.out.println(standardCache.getWeatherData("Moskov", 90));

            System.out.println(standardCache.getWeatherData("Test", 50000));
            Thread.sleep(100000);
            standardCache.clearExpiredCache(200);
            System.out.println(standardCache.getWeatherData("SBP", 50000));
            System.out.println(standardCache.getWeatherData("Moskov", 10));
            System.out.println();
        }
    }
