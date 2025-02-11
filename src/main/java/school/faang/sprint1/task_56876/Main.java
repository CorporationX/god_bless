package school.faang.sprint1.task_56876;

public class Main {
    public static void main(String[] args) {
        final StandartWeatherCache standartCache = new StandartWeatherCache();
        final FrequentUpdateWeatherCache frequentCache = new FrequentUpdateWeatherCache();

        long maxCacheAgeMillis = 10000;
        String city = "Moscow";

        WeatherData standartWeatherData = standartCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("Standart Cache: " + standartWeatherData);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        standartWeatherData = standartCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("Standart Cache after 5 seconds: " + standartWeatherData);

        WeatherData frequentWeatherData = frequentCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("Frequent Update Cache: " + frequentWeatherData);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        frequentWeatherData = frequentCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("Frequent Update Cache after 5 seconds: " + frequentWeatherData);
    }
}
