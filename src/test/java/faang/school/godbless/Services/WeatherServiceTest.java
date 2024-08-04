package faang.school.godbless.Services;

import org.junit.jupiter.api.Test;

import static faang.school.godbless.Main.weatherForecastMap;
import static faang.school.godbless.Services.WeatherService.*;
import static faang.school.godbless.Services.WeatherService.printAvailableCitiesInWeatherCache;
import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    @Test
    void infoWeatherByCityTest() {
        infoWeatherByCity("Moscow");
        infoWeatherByCity("SPB");
        infoWeatherByCity("Moscow");

        assertEquals(weatherForecastMap.keySet().size(), 2);
    }

    @Test
    void deleteWeatherCacheByCityTest() {
        infoWeatherByCity("Moscow");
        infoWeatherByCity("SPB");
        infoWeatherByCity("Moscow");

        assertEquals(weatherForecastMap.keySet().size(), 2);

        deleteWeatherCacheByCity("Moscow");

        assertEquals(weatherForecastMap.keySet().size(), 1);
    }
}