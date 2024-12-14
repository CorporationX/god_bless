package school.faang.sprint_1.task_44814;

public class Main {
    public static void main(String[] args) {
        WeatherProvider weatherService = new WeatherService();

        WeatherCacheTemplate weatherCache = new StandardWeatherCache(weatherService);
        long maxCacheAgeMillis = 5000;  // 5 секунд

        System.out.println("Получаем данные о погоде для Москвы...");
        WeatherData moscowWeather = weatherCache.getWeatherData("Москва", maxCacheAgeMillis);
        System.out.println("Погода для Москвы: " + moscowWeather);

        System.out.println("\nПолучаем данные о погоде для Москвы снова...");
        moscowWeather = weatherCache.getWeatherData("Москва", maxCacheAgeMillis);
        System.out.println("Погода для Москвы из кэша: " + moscowWeather);

        System.out.println("\nПринудительное обновление данных для Москвы...");
        weatherCache.forceUpdateWeather("Москва");
        moscowWeather = weatherCache.getWeatherData("Москва", maxCacheAgeMillis);
        System.out.println("Погода для Москвы после обновления: " + moscowWeather);

        System.out.println("\nУдаление устаревших данных из кэша...");
        weatherCache.clearExpiredCache(maxCacheAgeMillis);

        System.out.println("\nПолучаем данные о погоде для Санкт-Петербурга...");
        WeatherCacheTemplate frequentWeatherCache = new FrequentUpdateWeatherCache(weatherService);
        WeatherData spbWeather = frequentWeatherCache.getWeatherData("Санкт-Петербург", maxCacheAgeMillis);
        System.out.println("Погода для Санкт-Петербурга: " + spbWeather);

        System.out.println("\nПринудительное обновление данных для Санкт-Петербурга...");
        frequentWeatherCache.forceUpdateWeather("Санкт-Петербург");
        spbWeather = frequentWeatherCache.getWeatherData("Санкт-Петербург", maxCacheAgeMillis);
        System.out.println("Погода для Санкт-Петербурга после обновления: " + spbWeather);
    }
}
