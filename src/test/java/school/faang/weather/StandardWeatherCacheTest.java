package school.faang.weather;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
class StandardWeatherCacheTest {

    public static final String PERM_CITY = "Perm";
    public static final String MOSCOW_CITY = "Moscow";

    private final StandardWeatherCache cache = new StandardWeatherCache(new WeatherService());

    @AfterEach
    void tearDown() {
        cache.clearExpiredCache(0);
    }

    @Nested
    class getWeatherDataTest {

        @Test
        void givenCityWithNoData_thenForceUpdateWeather() {
            assertThat(cache.getWeatherDataByCity())
                    .isEmpty();
            cache.getWeatherData(PERM_CITY, 1000);
            assertThat(cache.getWeatherDataByCity())
                    .isNotEmpty();
        }

        @Test
        void givenCityWithExpiredCache_thenForceUpdateWeather() {
            cache.getWeatherData(PERM_CITY, 10);
            var oldWeatherData = cache.getWeatherDataByCity().get(PERM_CITY);

            await().atLeast(10, TimeUnit.MILLISECONDS).until(() -> true);

            cache.getWeatherData(PERM_CITY, 10);
            var newWeatherData = cache.getWeatherDataByCity().get(PERM_CITY);

            assertThat(oldWeatherData)
                    .isNotEqualTo(newWeatherData);
        }
    }

    @Test
    void testForceUpdateWeather() {
        cache.getWeatherData(PERM_CITY, 10000);
        var oldWeatherData = cache.getWeatherDataByCity().get(PERM_CITY);

        await().atLeast(20, TimeUnit.MILLISECONDS).until(() -> true);

        cache.forceUpdateWeather(PERM_CITY);
        var newWeatherData = cache.getWeatherDataByCity().get(PERM_CITY);

        assertThat(oldWeatherData)
                .isNotEqualTo(newWeatherData);
    }

    @Test
    void testClearExpiredCache() {
        cache.getWeatherData(MOSCOW_CITY, 100);
        WeatherData oldData = new WeatherData(PERM_CITY, 10, 10, System.currentTimeMillis() - 1000);
        cache.getWeatherDataByCity().put(PERM_CITY, oldData);

        cache.clearExpiredCache(10);

        assertThat(cache.getWeatherDataByCity())
                .hasSize(1)
                .containsKey(MOSCOW_CITY);
    }
}