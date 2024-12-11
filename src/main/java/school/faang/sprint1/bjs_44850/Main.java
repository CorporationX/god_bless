package school.faang.sprint1.bjs_44850;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        long maxMillis = 1733934640345L;
        WeatherProvider weatherProvider = new WeatherService();
        WeatherData weatherData;

        WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache(maxMillis, weatherProvider);
        WeatherCacheTemplate frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(weatherProvider);

        weatherData = standardWeatherCache.getWeatherData("Moscow");
        printData(weatherData);

        weatherData = frequentUpdateWeatherCache.getWeatherData("Voronezh");
        printData(weatherData);
    }

    private Map<String, WeatherData> initMap() {
        Map<String, WeatherData> weatherData = new HashMap<>();

        String[][] data = {
                {"Moscow", "5.0", "45.5", "1733509975637"},
                {"Rostov-Na-Donu", "6.0", "35.0", "1733509925656"},
                {"Sankt Peterburg", "3.5", "60.0", "1733508915637"},
                {"Voronezh", "4.0", "40.5", "1733509910000"},
                {"Krasnodar", "8.0", "80.5", "1733509805637"},
                {"Sochi", "12.0", "100.0", "1733509966637"},
        };

        for (String[] city : data) {
            String key = city[0];
            String name = key;
            double temperature = Double.parseDouble(city[1]);
            double humidity = Double.parseDouble(city[2]);
            long timestamp = Long.parseLong(city[3]);

            weatherData.put(key, new WeatherData(name, temperature, humidity, timestamp));
        }

        return weatherData;
    }

    private static void printData(WeatherData weatherData) {
        System.out.println("Город: " + weatherData.getCity());
        System.out.println("Температура: " + weatherData.getTemperature());
        System.out.println("Влажность: " + weatherData.getHumidity());
        System.out.println("Последнее обновление: " + new Date(weatherData.getTimestamp()));
        System.out.println("=============");
    }
}
