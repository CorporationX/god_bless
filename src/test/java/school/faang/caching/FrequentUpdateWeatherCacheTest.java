package school.faang.caching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrequentUpdateWeatherCacheTest {

    private FrequentUpdateWeatherCache frequentUpdateWeatherCache;
    private String moscow;

    @BeforeEach
    public void setUp() {
        frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
        moscow = "Moscow";
    }

    @Test
    @DisplayName("Данные в кэше обновляются в любом случае")
    public void testClearExpiredCache() {
        WeatherData firstData = frequentUpdateWeatherCache.getWeatherData(moscow, 5000);
        WeatherData secondData = frequentUpdateWeatherCache.getWeatherData(moscow, 5000);
        assertThat(firstData).isNotEqualTo(secondData);
    }
}
