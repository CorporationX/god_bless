package school.faang.BJS2_56884;

public class Main {
    public static void main(String[] args) {
        WeatherProvider service = new WeatherService();

        WeatherCacheTemplate standard = new StandardWeatherCache(service);
        WeatherData data = standard.getWeatherData("Moscow", 300);
        System.out.println(standard.cache);
        System.out.println(standard.getWeatherData("Moscow", 300));

        WeatherCacheTemplate frequent = new FrequentUpdateWeatherCache(service);
        WeatherData data1 = frequent.getWeatherData("Moscow", 300);
        System.out.println(frequent.cache);
    }
}
