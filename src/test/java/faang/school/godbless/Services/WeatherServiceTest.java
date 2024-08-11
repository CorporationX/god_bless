package faang.school.godbless.Services;

import faang.school.godbless.models.WeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static faang.school.godbless.Services.WeatherService.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherServiceTest {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final String MOSCOW = "Moscow";
    public static final String SPB = "SPB";

    public static HashMap<String, WeatherData> weatherForecastMap = new HashMap<>();

    @BeforeEach
    void init() {
        printInfoFromCacheByCityAndPutInCacheIfNotExist(MOSCOW, weatherForecastMap);
        printInfoFromCacheByCityAndPutInCacheIfNotExist(SPB, weatherForecastMap);
        printInfoFromCacheByCityAndPutInCacheIfNotExist(MOSCOW, weatherForecastMap);
    }

    @Test
    void infoWeatherByCityTest() {
        assertEquals(weatherForecastMap.keySet().size(), TWO);
    }

    @Test
    void deleteWeatherCacheByCityTest() {
        assertEquals(weatherForecastMap.keySet().size(), TWO);

        deleteWeatherCacheByCity(MOSCOW, weatherForecastMap);

        assertEquals(weatherForecastMap.keySet().size(), ONE);
    }

    @Test
    void updateWeatherCacheByCityTest() {
        printAvailableCitiesInWeatherCache(weatherForecastMap);

        System.out.println(weatherForecastMap);
        updateWeatherCacheByCity(MOSCOW, weatherForecastMap);
        assertEquals(weatherForecastMap.keySet().size(), TWO);

        printAvailableCitiesInWeatherCache(weatherForecastMap);
        System.out.println(weatherForecastMap);
    }
}