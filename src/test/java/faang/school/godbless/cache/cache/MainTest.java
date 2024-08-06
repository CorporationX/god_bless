package faang.school.godbless.cache.cache;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

    @BeforeEach
    void setDataToCache() {
        Main.cityWeatherCache.put("London", new WeatherData("London", 50, 50));
        Main.cityWeatherCache.put("New York", new WeatherData("New York", 70, 70));
    }

    @AfterEach
    void cleanCache() {
        Main.cityWeatherCache.clear();
    }

    @Test
    void testGetWeather() {
        Assertions.assertNull(Main.cityWeatherCache.get("Moscow"));
        WeatherData initMoscowData = Main.getWeather("Moscow");
        Assertions.assertNotNull(Main.cityWeatherCache.get("Moscow"));

        int initTemperature = initMoscowData.getTemperature();
        int initHumidity = initMoscowData.getHumidity();

        WeatherData moscowData = Main.getWeather("Moscow");
        Assertions.assertEquals(initTemperature, moscowData.getTemperature());
        Assertions.assertEquals(initHumidity, moscowData.getHumidity());
    }

    @Test
    void testUpdate() {
        WeatherData firstLondonData = Main.cityWeatherCache.get("London");
        Assertions.assertEquals(50, firstLondonData.getTemperature());
        Assertions.assertEquals(50, firstLondonData.getHumidity());

        Main.update(new WeatherData("London", 10, 10));


        WeatherData secondLondonData = Main.cityWeatherCache.get("London");
        Assertions.assertEquals(10, secondLondonData.getTemperature());
        Assertions.assertEquals(10, secondLondonData.getHumidity());
    }

    @Test
    void testDelete() {
        Assertions.assertEquals(2, Main.cityWeatherCache.size());
        Main.delete("New York");
        Assertions.assertEquals(1, Main.cityWeatherCache.size());
    }
}
