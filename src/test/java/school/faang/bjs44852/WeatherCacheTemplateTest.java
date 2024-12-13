package school.faang.bjs44852;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

class WeatherCacheTemplateTest {

    @Nested
    class gettingWeatherTest {
        private final WeatherProvider weatherProvider = mock(WeatherProvider.class);
        private WeatherCacheTemplate cacheService;

        @BeforeEach
        public void setUp() {
            cacheService = mock(WeatherCacheTemplate.class, withSettings().useConstructor(weatherProvider).defaultAnswer(CALLS_REAL_METHODS));
        }

        @Test
        public void shouldMakeRequestForNonExistingData() {
            String city = "New York";
            cacheService.getWeatherData(city, 1);

            verify(weatherProvider, times(1)).fetchWeatherData(city);
        }

        @Test
        public void shouldReturnNewDataAfterExpiration() {
            String city = "New York";
            cacheService.getWeatherData(city, 1);

            when(cacheService.checkIfDataActual(any(), anyLong())).thenReturn(false);
            cacheService.getWeatherData(city, 1);

            verify(weatherProvider, times(2)).fetchWeatherData(city);
        }

        @Test
        public void shouldNotMakeRequestForExistingData() {
            String city = "New York";
            cacheService.getWeatherData(city, 1);

            when(cacheService.checkIfDataActual(any(), anyLong())).thenReturn(true);
            cacheService.getWeatherData(city, 1);

            verify(weatherProvider, times(1)).fetchWeatherData(ArgumentMatchers.any());
        }
    }


    @Nested
    class clearCacheTest {
        WeatherProvider weatherProvider;

        @BeforeEach
        void setUp() {
            weatherProvider = new WeatherService();
        }

        @Test
        void shouldDeleteExpiredCache() throws InterruptedException {
            WeatherCacheTemplate standardCache = new StandardWeatherCache(weatherProvider);
            String city = "New York";

            standardCache.getWeatherData(city, 1);
            Thread.sleep(1);
            standardCache.clearExpiredCache(0);

            Assertions.assertEquals(0, standardCache.data.size());
        }

        @Test
        void shouldNotDeleteActualCache() {
            WeatherCacheTemplate standardCache = new StandardWeatherCache(weatherProvider);
            String city = "New York";

            standardCache.getWeatherData(city, 1);
            standardCache.clearExpiredCache(Long.MAX_VALUE);

            Assertions.assertEquals(1, standardCache.data.size());
        }
    }
}