package school.faang.task_44819;

public class Main {
    public static void main(String[] args) {
        StandardWeatherCache standardWeatherCache = new StandardWeatherCache(new WeatherService());
        standardWeatherCache.getWeatherData("Surgut", 90000);
        System.out.println(standardWeatherCache.getWeatherCache().toString());
        System.out.println("<------------------------------------------->");
        standardWeatherCache.getWeatherData("Surgut", 1);
        System.out.println(standardWeatherCache.getWeatherCache().toString());
        standardWeatherCache.clearExpiredCache(100000);
        System.out.println(standardWeatherCache.getWeatherCache().toString());

        FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(new WeatherService());
        frequentUpdateWeatherCache.getWeatherData("Moscow", 8000);
    }
}
