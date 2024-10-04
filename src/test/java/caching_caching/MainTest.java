package caching_caching;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void getWeatherData() {
        WeatherData weatherData = Main.getWeather("London");
        assertEquals(Main.weatherData.toString(), "{London=" + weatherData.toString() + "}");
        Main.deleteWeatherData("London");
    }

    @Test
    void updateWeatherData() {
        WeatherData weatherData = Main.getWeather("London");
        Main.updateWeatherData("London");
        assertNotEquals(Main.weatherData.toString(), "{London=" + weatherData.toString() + "}");
    }

    @Test
    void deleteWeatherData() {
        Main.getWeather("London");
        Main.deleteWeatherData("London");
        assertNull(Main.weatherData.get("London"));
    }

    @Test
    void printAllWeatherData() {
        Main.getWeather("London");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.printAllWeatherData();

        assertTrue(outContent.toString().contains("London: WeatherData(city=London, "));

        System.setOut(originalOut);

        Main.deleteWeatherData("London");
    }
}