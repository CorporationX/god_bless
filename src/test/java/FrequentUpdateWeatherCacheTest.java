import org.junit.jupiter.api.Test;
import school.faang.task_44821.City;
import school.faang.task_44821.FrequentUpdateWeatherCache;
import school.faang.task_44821.WeatherData;
import school.faang.task_44821.WeatherProvider;
import school.faang.task_44821.WeatherService;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FrequentUpdateWeatherCacheTest {
    private final WeatherProvider weatherProvider = new WeatherService();
    private final FrequentUpdateWeatherCache cache = new FrequentUpdateWeatherCache(weatherProvider);

    @Test
    void testCacheAlwaysUpdatesData_frequentUpdateWeatherCachePositive() {

        WeatherData oldWeatherData = cache.getWeatherData(City.MOSCOW);
        WeatherData newWeatherData = cache.getWeatherData(City.MOSCOW);

        assertNotEquals(
                oldWeatherData,
                newWeatherData,
                "Data should always update in FrequentUpdateWeatherCache."
        );
    }
}