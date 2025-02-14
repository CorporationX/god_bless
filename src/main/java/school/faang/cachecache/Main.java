package school.faang.cachecache;

public class Main {
    public static void main(String[] args) throws Exception {
        WeatherProvider weatherService = new WeatherService();
        WeatherCacheTemplate standart = new StandardWeatherCache(weatherService);
        long standartCache = 7000;

        String city = "Kazan";

        System.out.println("standart update cache");
        System.out.println(standart.getWeatherData(city, standartCache));
        Thread.sleep(8000);
        System.out.println(standart.getWeatherData(city, standartCache));

        WeatherCacheTemplate frequent = new FrequentUpdateWeatherCache(weatherService);
        System.out.println("frequent update cache");
        System.out.println(frequent.getWeatherData(city, standartCache));
        System.out.println(frequent.getWeatherData(city, standartCache));


    }
}
