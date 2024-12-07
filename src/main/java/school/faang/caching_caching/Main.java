package school.faang.caching_caching;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final WeatherService service = new WeatherService();
        final StandardWeatherCache standardWeatherCache = new StandardWeatherCache(service);
        final FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(service);

        WeatherData moscowWeather = standardWeatherCache.getWeatherData("Moscow", 0);
        System.out.println(moscowWeather);
        System.out.println();

        WeatherData oldCache;

        System.out.println("Test: update cache by expiration");
        oldCache = moscowWeather;
        moscowWeather = standardWeatherCache.getWeatherData("Moscow", 0);
        System.out.println(moscowWeather);
        if (oldCache != moscowWeather) {
            System.out.println("Test result: GOOD");
        } else {
            System.out.println("Test result: BAD");
        }
        System.out.println();

        System.out.println("Test: try to update cache before expiration");
        oldCache = moscowWeather;
        moscowWeather = standardWeatherCache.getWeatherData("Moscow", 300);
        System.out.println(moscowWeather);
        if (oldCache == moscowWeather) {
            System.out.println("Test result: GOOD");
        } else {
            System.out.println("Test result: BAD");
        }
        System.out.println();

        Thread.sleep(300);
        System.out.println("Test: try to update cache after expiration");
        oldCache = moscowWeather;
        moscowWeather = standardWeatherCache.getWeatherData("Moscow", 300);
        System.out.println(moscowWeather);
        if (oldCache != moscowWeather) {
            System.out.println("Test result: GOOD");
        } else {
            System.out.println("Test result: BAD");
        }
        System.out.println();

        WeatherData yekaterinburgWeather = standardWeatherCache.getWeatherData("Yekaterinburg", 0);
        System.out.println(yekaterinburgWeather);
        System.out.println("Test: force the cache to be updated despite expiration");
        oldCache = yekaterinburgWeather;
        yekaterinburgWeather = frequentUpdateWeatherCache.getWeatherData(yekaterinburgWeather.getCity(), 1000);
        System.out.println(yekaterinburgWeather);
        if (oldCache != yekaterinburgWeather) {
            System.out.println("Test result: GOOD");
        } else {
            System.out.println("Test result: BAD");
        }
        System.out.println();

        System.out.println("Test: clearExpiredCache");
        oldCache = moscowWeather;
        standardWeatherCache.clearExpiredCache(0);
        moscowWeather = standardWeatherCache.getWeatherData("Moscow", 0);
        if (oldCache != moscowWeather) {
            System.out.println("Test result: GOOD");
        } else {
            System.out.println("Test result: BAD");
        }
    }
}
