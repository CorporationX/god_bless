package faang.school.godbless.javahashmap.cache;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeteorologistTest {

    private static final String LONDON = "London";
    private static final String MOSCOW = "Moscow";
    private static final String PARIS = "Paris";
    private static final String NEW_YORK = "New York";

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final String ALL_WEATHER_DATA_INFO = """
            WeatherData(city=New York, temperature=15.5, humidity=74.8)\r
            WeatherData(city=London, temperature=15.5, humidity=74.8)\r
            WeatherData(city=Moscow, temperature=15.5, humidity=74.8)\r
            WeatherData(city=Paris, temperature=15.5, humidity=74.8)\r
            """;

    private WeatherData weatherDataLondon;
    private WeatherData weatherDataMoscow;
    private WeatherData weatherDataParis;
    private WeatherData weatherDataNewYork;

    @Test
    void testGetWeatherData() {
        Meteorologist meteorologist = new Meteorologist();

        fillCache(meteorologist);

        HashMap<String, WeatherData> weatherDataCache = meteorologist.getWeatherDataCache();
        assertEquals(4, weatherDataCache.size());
        assertEquals(weatherDataLondon, weatherDataCache.get(LONDON));
        assertEquals(weatherDataMoscow, weatherDataCache.get(MOSCOW));
        assertEquals(weatherDataParis, weatherDataCache.get(PARIS));
        assertEquals(weatherDataNewYork, weatherDataCache.get(NEW_YORK));
    }

    @Test
    void testUpdateWeatherData() {
        Meteorologist meteorologist = new Meteorologist();

        fillCache(meteorologist);
        WeatherData updatedWeatherDataLondon = new WeatherData(LONDON, 21, 20);
        meteorologist.updateWeatherData(LONDON, updatedWeatherDataLondon);

        HashMap<String, WeatherData> weatherDataCache = meteorologist.getWeatherDataCache();
        assertEquals(4, weatherDataCache.size());
        assertEquals(updatedWeatherDataLondon, weatherDataCache.get(LONDON));
        assertEquals(weatherDataMoscow, weatherDataCache.get(MOSCOW));
        assertEquals(weatherDataParis, weatherDataCache.get(PARIS));
        assertEquals(weatherDataNewYork, weatherDataCache.get(NEW_YORK));
    }

    @Test
    void testDeleteWeatherData() {
        Meteorologist meteorologist = new Meteorologist();

        fillCache(meteorologist);
        meteorologist.deleteWeatherData(LONDON);

        HashMap<String, WeatherData> weatherDataCache = meteorologist.getWeatherDataCache();
        assertEquals(3, weatherDataCache.size());
        assertEquals(weatherDataMoscow, weatherDataCache.get(MOSCOW));
        assertEquals(weatherDataParis, weatherDataCache.get(PARIS));
        assertEquals(weatherDataNewYork, weatherDataCache.get(NEW_YORK));
    }

    @Test
    void testPrintCachedCities() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        Meteorologist meteorologist = new Meteorologist();

        fillCache(meteorologist);
        meteorologist.printCachedCities();

        assertEquals(ALL_WEATHER_DATA_INFO, outContent.toString());
        System.setOut(originalOut);
    }

    private void fillCache(Meteorologist meteorologist) {
        weatherDataLondon = meteorologist.getWeatherData(LONDON);
        weatherDataMoscow = meteorologist.getWeatherData(MOSCOW);
        weatherDataParis = meteorologist.getWeatherData(PARIS);
        weatherDataNewYork = meteorologist.getWeatherData(NEW_YORK);
    }
}