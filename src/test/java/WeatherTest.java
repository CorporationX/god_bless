import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import faang.school.godbless.BJS2_18822.DB;
import faang.school.godbless.BJS2_18822.Main;
import faang.school.godbless.BJS2_18822.WeatherData;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {
    @BeforeEach
    public void setUp() {
        Main.cache.clear();
    }

    @Test
    public void testInfoWeather_CityInCache() {
        Main.cache.put("London", new WeatherData("London", "17°C", "20%"));

        WeatherData result = Main.infoWeather("London");
        assertEquals("London", result.getCity());
        assertEquals("17°C", result.getTemperature());
        assertEquals("20%", result.getHumidity());
    }

    @Test
    public void testInfoWeather_CityNotInCache() {
        assertNull(Main.cache.get("Tokyo"));

        WeatherData result = Main.infoWeather("Tokyo");
        assertEquals("Tokyo", result.getCity());
        assertEquals("20°C", result.getTemperature());
        assertEquals("65%", result.getHumidity());

        WeatherData cachedResult = Main.cache.get("Tokyo");
        assertNotNull(cachedResult);
        assertEquals("Tokyo", cachedResult.getCity());
        assertEquals("20°C", cachedResult.getTemperature());
        assertEquals("65%", cachedResult.getHumidity());
    }

}
