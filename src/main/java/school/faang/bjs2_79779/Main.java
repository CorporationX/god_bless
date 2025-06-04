package school.faang.bjs2_79779;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        WeatherProvider weatherProvider = new WeatherService();
        WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache(weatherProvider);

        String krasnodar = "Krasnodar";
        String seoul = "Seoul";
        WeatherData krasnodarWeatherData = standardWeatherCache.getWeatherData(krasnodar, 1);
        WeatherData seoulWeatherData = standardWeatherCache.getWeatherData(seoul, 1);
        log.info("Погода: {}; {}", krasnodarWeatherData, seoulWeatherData);

        krasnodarWeatherData = standardWeatherCache.getWeatherData(krasnodar, 10000);
        seoulWeatherData = standardWeatherCache.getWeatherData(seoul, 10000);
        log.info("Погода: {}; {}", krasnodarWeatherData, seoulWeatherData);

        krasnodarWeatherData = standardWeatherCache.getWeatherData(krasnodar, 1);
        seoulWeatherData = standardWeatherCache.getWeatherData(seoul, 1);
        log.info("Погода: {}; {}", krasnodarWeatherData, seoulWeatherData);

        WeatherCacheTemplate frequentUpdateWeatherCache = new FrequentUpdateWeatherCache(weatherProvider);

        krasnodarWeatherData = frequentUpdateWeatherCache.getWeatherData(krasnodar, 10000);
        seoulWeatherData = frequentUpdateWeatherCache.getWeatherData(seoul, 10000);
        log.info("Погода: {}; {}", krasnodarWeatherData, seoulWeatherData);
    }
}
