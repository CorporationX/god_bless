package school.faang.weather;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.awaitility.Durations.FIVE_SECONDS;
import static org.awaitility.Durations.ONE_HUNDRED_MILLISECONDS;

class StandardWeatherCacheTest {

    private final WeatherCacheTemplate standardWeatherCache = new StandardWeatherCache();

    @Test
    void testGetWeatherDataLongCache() throws InterruptedException {
        long cacheAge = 1000;
        String city = "New-York";

        WeatherData firstRequest = standardWeatherCache.getWeatherData(city, cacheAge);

        waiter(() -> firstRequest.equals(standardWeatherCache.getWeatherData(city, cacheAge)));
        waiter(() -> !firstRequest.equals(standardWeatherCache.getWeatherData(city, cacheAge)));
    }

    @Test
    void testGetWeatherDataSmallCache() throws InterruptedException {
        long cacheAge = 10;
        String city = "New-York";
        WeatherData weatherData = standardWeatherCache.getWeatherData(city, cacheAge);

        Assertions.assertEquals(weatherData, standardWeatherCache.getWeatherData(city, cacheAge));

        sleep(10);

        Assertions.assertNotEquals(weatherData, standardWeatherCache.getWeatherData(city, cacheAge));
    }

    @Test
    void testGetWeatherDataForce() {
        long cacheAge = 10000;
        String city = "New-York";
        WeatherData firstRequest = standardWeatherCache.getWeatherData(city, cacheAge);
        Assertions.assertEquals(firstRequest, standardWeatherCache.getWeatherData(city, cacheAge));

        WeatherData forced = standardWeatherCache.forceUpdateWeather(city);
        Assertions.assertNotEquals(firstRequest, forced);
        WeatherData secondRequest = standardWeatherCache.getWeatherData(city, cacheAge);
        Assertions.assertNotEquals(firstRequest, secondRequest);
        Assertions.assertEquals(secondRequest, forced);
    }

    private void waiter(Callable<Boolean> conditionEvaluator) {
        Awaitility.await()
                .pollInterval(ONE_HUNDRED_MILLISECONDS)
                .atMost(FIVE_SECONDS.toSeconds(), TimeUnit.SECONDS)
                .until(conditionEvaluator);
    }

}