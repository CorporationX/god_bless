package school.faang.sprintone.cachingcaching;

public class Main {
    public static void main(String[] args) {
        // Создание провайдера погоды
        WeatherProvider provider = new WeatherService();
        // Создание кэшей
        StandardWeatherCache standardCache = new StandardWeatherCache(provider);
        FrequentUpdateWeatherCache frequentCache = new FrequentUpdateWeatherCache(provider);

        // Получение данных через стандартный кэш
        System.out.println("Стандартный кэш:");
        WeatherData standardData1 = standardCache.getWeatherData("Moscow", 10000);
        System.out.println("Первый запрос: " + standardData1.getTemperature() + "°C");

        // Получение данных через кэш с частым обновлением
        System.out.println("\nКэш с частым обновлением:");
        WeatherData frequentData1 = frequentCache.getWeatherData("StPetersburg", 10000);
        System.out.println("Первый запрос: " + frequentData1.getTemperature() + "°C");

        // Второй запрос возвращает данные из кэша
        WeatherData standardData2 = standardCache.getWeatherData("Moscow", 10000);
        System.out.println("Второй запрос: " + standardData2.getTemperature() + "°C");

        // Принудительное обновление данных
        standardCache.forceUpdateWeather("Moscow");
        WeatherData standardData3 = standardCache.getWeatherData("Moscow", 10000);
        System.out.println("После принудительного обновления: " + standardData3.getTemperature() + "°C");

        // Каждый запрос возвращает новые данные
        WeatherData frequentData2 = frequentCache.getWeatherData("StPetersburg", 10000);
        System.out.println("Второй запрос: " + frequentData2.getTemperature() + "°C");

        // Очистка устаревших данных из стандартного кэша
        System.out.println("\nОчистка устаревших данных:");
        standardCache.clearExpiredCache(10);
        System.out.println("Данные после очистки: " + (standardCache.cache.isEmpty() ? "пусто" : "есть данные"));

    }
}
