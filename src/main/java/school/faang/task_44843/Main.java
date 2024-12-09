package school.faang.task_44843;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Проверки для StandardWeatherCache
        var standardWeatherCache = new StandardWeatherCache();

        //Проверка кэширования данных, когда данные не истекли
        var weatherFromCache1 = standardWeatherCache.getWeatherData("Moscow");
        Thread.sleep(100);
        var weatherFromCache2 = standardWeatherCache.getWeatherData("Moscow");
        assert weatherFromCache1 == weatherFromCache2;

        //Проверка кэширования данных, когда данные истекли
        Thread.sleep(5000);
        var expiredWeatherFromCache3 = standardWeatherCache.getWeatherData("Moscow");
        assert weatherFromCache1 != expiredWeatherFromCache3;

        //Проверка удаления истекших данных
        standardWeatherCache.getCache().put("Boston", new WeatherData("Boston"));
        standardWeatherCache.clearExpiredCache(1200);
        assert standardWeatherCache.getCache().keySet().size() == 2;

        //Проверки для FrequentUpdateWeatherCache
        var frequentWeatherCache = new FrequentUpdateWeatherCache(150);

        //Проверка кэширования данных, когда данные не истекли
        var weatherFromCache4 = frequentWeatherCache.getWeatherData("LA");
        Thread.sleep(100);
        var weatherFromCache5 = frequentWeatherCache.getWeatherData("LA");
        assert weatherFromCache4 == weatherFromCache5;

        //Проверка кэширования данных, когда данные истекли
        Thread.sleep(1000);
        var expiredWeatherFromCache5 = frequentWeatherCache.getWeatherData("LA");
        assert weatherFromCache4 != expiredWeatherFromCache5;

        //Проверка удаления истекших данных
        frequentWeatherCache.getCache().put("LA", new WeatherData("LA"));
        frequentWeatherCache.clearExpiredCache(1200);
        assert frequentWeatherCache.getCache().keySet().size() == 2;
    }
}
