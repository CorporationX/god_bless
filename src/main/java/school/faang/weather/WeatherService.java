package school.faang.weather;

import java.util.Map;

public class WeatherService {
    public static WeatherData provideData(String city) {
        double temperature = Math.random() * 30;
        double humidity = Math.random() * 100;
        return new WeatherData(city, temperature, humidity);
    }

    public static void addWeather(WeatherData weatherData, Map<String, WeatherData> weatherCache) {
        weatherCache.put(weatherData.getCity(), weatherData);
    }

    public static void addWeather(String city, Map<String, WeatherData> weatherCache) {
        weatherCache.put(city, provideData(city));
    }

    public static WeatherData getWeatherData(String city, Map<String, WeatherData> weatherCache) {
        if (!weatherCache.containsKey(city)) {
            weatherCache.put(city, provideData(city));
        }
        return weatherCache.get(city);
    }

    public static void updateWeatherData(String city, Map<String, WeatherData> weatherCache) {
        weatherCache.put(city, provideData(city));
    }

    public static void removeWeatherData(String city, Map<String, WeatherData> weatherCache) {
        weatherCache.remove(city);
    }

    public static void printWeatherData(Map<String, WeatherData> weatherCache) {
        weatherCache.forEach((k, v) -> {
            System.out.printf("In %s city %.2f degrees and %.2f humidity\n", k, v.getTemp(), v.getHumidity());
        });
    }
}
