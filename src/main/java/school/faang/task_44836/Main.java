package school.faang.task_44836;

public class Main {
    public static void main(String[] args) {
        WeatherProvider weatherService = new WeatherService();

        WeatherCacheTemplate standardCache = new StandardWeatherCache(weatherService);
        WeatherData data1 = standardCache.getWeatherData("Moscow", 5000);
        System.out.println("Temperature in Moscow: " + data1.getTemperature());

        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(weatherService);
        WeatherData data2 = frequentCache.getWeatherData("Saint Petersburg", 5000);
        System.out.println("Temperature in Saint Petersburg: " + data2.getTemperature());
    }
}