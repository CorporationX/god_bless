package school.faang.task_44824;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Создаем сервис погоды
        WeatherService weatherService = new WeatherService();

        // Тестируем FrequentUpdateWeatherCache
        System.out.println("=== FrequentUpdateWeatherCache Tests ===");
        FrequentUpdateWeatherCache frequentCache = new FrequentUpdateWeatherCache(weatherService);

        WeatherData moscowWeather1 = frequentCache.getWeatherData(City.MOSCOW);
        System.out.println("Initial Moscow weather: " + moscowWeather1);

        Thread.sleep(1000); // Задержка для проверки обновления
        WeatherData moscowWeather2 = frequentCache.getWeatherData(City.MOSCOW);
        System.out.println("Updated Moscow weather: " + moscowWeather2);

        System.out.println("Data updated? " + (moscowWeather1 != moscowWeather2));

        // Тестируем StandartWeatherCache
        System.out.println("\n=== StandartWeatherCache Tests ===");
        StandardWeatherCache standartCache = new StandardWeatherCache(weatherService);

        WeatherData ufaWeather1 = standartCache.getWeatherData(City.UFA);
        System.out.println("Initial Ufa weather: " + ufaWeather1);

        Thread.sleep(500); // Задержка, меньше времени истечения кэша
        WeatherData ufaWeather2 = standartCache.getWeatherData(City.UFA);
        System.out.println("Cached Ufa weather: " + ufaWeather2);

        System.out.println("Data cached? " + (ufaWeather1 == ufaWeather2));

        Thread.sleep(2000); // Задержка, превышающая время истечения кэша
        WeatherData ufaWeather3 = standartCache.getWeatherData(City.UFA);
        System.out.println("Updated Ufa weather: " + ufaWeather3);

        System.out.println("Data updated? " + (ufaWeather1 != ufaWeather3));
    }
}
