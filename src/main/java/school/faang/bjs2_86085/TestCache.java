package school.faang.bjs2_86085;

public class TestCache {
    public static void main(String[] args) {
        // Создаем mock провайдера с правильным именем метода
        WeatherProvider provider = new WeatherProvider() {
            @Override
            public WeatherData fetchWeatherData(String city) {  // ← Исправлено на fetchWeatherData
                return new WeatherData(city, Math.random() * 40 - 10, Math.random() * 100, System.currentTimeMillis());
            }
        };

        FrequentUpdateWeatherCache cache = new FrequentUpdateWeatherCache(provider);

        // Создаем данные, которые "устарели" на 100 мс
        WeatherData oldData = new WeatherData("Test", 20.0, 50.0, System.currentTimeMillis() - 100);

        // Тестируем с разными значениями
        System.out.println("maxAge = 0: " + cache.isCacheExpired(oldData, 0)); // true
        System.out.println("maxAge = 1: " + cache.isCacheExpired(oldData, 1)); // true
        System.out.println("maxAge = 1000: " + cache.isCacheExpired(oldData, 1000)); // false
        System.out.println("maxAge = 50: " + cache.isCacheExpired(oldData, 50)); // true

        // Тестируем с только что созданными данными
        WeatherData freshData = new WeatherData("Test", 20.0, 50.0, System.currentTimeMillis());
        System.out.println("Fresh data, maxAge = 1000: " + cache.isCacheExpired(freshData, 1000)); // false
        System.out.println("Fresh data, maxAge = 0: " + cache.isCacheExpired(freshData, 0)); // true
    }
}