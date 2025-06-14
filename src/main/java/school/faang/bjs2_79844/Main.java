package school.faang.bjs2_79844;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        StandartWeatherCache cache = new StandartWeatherCache(weatherService);

        WeatherData data = cache.getWeatherData("London", 5000);

        System.out.printf("city: %s%n", data.getCity());
        System.out.printf("temperature: %d%n", (int) data.getTemperature());
        System.out.printf("humidity: %d%n", (int) data.getHumidity());
        System.out.printf("timestamp: %d%n", data.getTimestamp());
    }
}
