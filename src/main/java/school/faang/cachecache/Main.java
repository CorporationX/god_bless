package school.faang.cachecache;

public class Main {
    public static void main(String[] args) throws Exception {
        WeatherProvider weatherService = new WeatherService();
        WeatherCacheTemplate standart = new StandardWeatherCache(weatherService);
        long standardCache = 7000;

        String city = "Kazan";

        System.out.println("standard update cache");
        System.out.println(standart.getWeatherData(city, standardCache));
        Thread.sleep(8000);
        System.out.println(standart.getWeatherData(city, standardCache));

        WeatherCacheTemplate frequent = new FrequentUpdateWeatherCache(weatherService);
        System.out.println("frequent update cache");
        System.out.println(frequent.getWeatherData(city, standardCache));
        System.out.println(frequent.getWeatherData(city, standardCache));


    }
}
