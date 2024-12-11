package school.faang.s13task44826;

public class Main {
    public static void main(String[] args) {
        WeatherProvider provider = new WeatherService();
        WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache(provider);
        WeatherCacheTemplate frequentWeatherCache = new FrequentUpdateWeatherCache(provider);

        System.out.println(standardWeatherCache.getWeatherData(City.NOVOSIBIRSK, 1000));
        System.out.println(frequentWeatherCache.getWeatherData(City.NOVOSIBIRSK, 1000));
        System.out.println("***");
        System.out.println(standardWeatherCache.getWeatherData(City.NIGNIY_NOVGOROD, 1000));
        System.out.println(frequentWeatherCache.getWeatherData(City.NIGNIY_NOVGOROD, 1000));
    }
}