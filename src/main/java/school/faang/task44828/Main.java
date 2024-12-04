package school.faang.task44828;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherData weatherData =
                new WeatherData("Moscow",
                        25d,
                        50d,
                        System.currentTimeMillis());
        WeatherData weatherData2 =
                new WeatherData(
                        "Kirov",
                        30d,
                        60d,
                        System.currentTimeMillis());
        WeatherData weatherData3 =
                new WeatherData(
                        "Vyatskie Poluany",
                        15d,
                        50d,
                        System.currentTimeMillis());
        WeatherData weatherData4 =
                new WeatherData(
                        "Sosnovka",
                        10d,
                        60d,
                        System.currentTimeMillis());

        Map<String, WeatherData> map = new HashMap<>(Map.of(
                weatherData.getCity(), weatherData,
                weatherData2.getCity(), weatherData2,
                weatherData3.getCity(), weatherData3,
                weatherData4.getCity(), weatherData4
        ));

        WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache(map);

        System.out.println(standardWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(standardWeatherCache.getWeatherData("Vyatskie Poluany").toString());
        System.out.println(standardWeatherCache.getWeatherData("Moscow").toString());
        System.out.println(standardWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(standardWeatherCache.getWeatherData("Berlin").toString());
        Thread.sleep(Duration.ofSeconds(15).toMillis());

        System.out.println(standardWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(standardWeatherCache.getWeatherData("Vyatskie Poluany").toString());
        System.out.println(standardWeatherCache.getWeatherData("Moscow").toString());
        System.out.println(standardWeatherCache.getWeatherData("Kirov").toString());
        System.out.println(standardWeatherCache.getWeatherData("Berlin").toString());

    }
}
