package school.faang.cachecache;

public class App {
    public static void main(String[] args) throws InterruptedException {
        WeatherService weatherService = new WeatherService();

        // Пример использования StandardWeatherCache
        WeatherCacheTemplate standardCache = new StandardWeatherCache(weatherService);
        WeatherData data1 = standardCache.getWeatherData("Moscow", 5000);
        System.out.println("Температура в Москве: " + data1.getTemperature() + "°C");

        Thread.sleep(2000);

        WeatherData data2 = standardCache.getWeatherData("Moscow", 5000);
        System.out.println("Температура в Москве: " + data2.getTemperature() + "°C");

        Thread.sleep(4000);

        WeatherData data3 = standardCache.getWeatherData("Moscow", 5000);
        System.out.println("Температура в Москве: " + data3.getTemperature() + "°C");

        // Пример использования FrequentUpdateWeatherCache
        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(weatherService);
        WeatherData data4 = frequentCache.getWeatherData("London", 5000);
        System.out.println("Температура в Лондоне: " + data4.getTemperature() + "°C");

        WeatherData data5 = frequentCache.getWeatherData("London", 5000);
        System.out.println("Температура в Лондоне: " + data5.getTemperature() + "°C");
    }
}
