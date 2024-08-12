package faang.school.godbless.BJS2_19053;

import org.junit.jupiter.api.Test;

import static faang.school.godbless.BJS2_19053.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testGetWeatherInformationByCityName() {
        assertEquals(new WeatherData(SAMARA, 20.3, 80), Main.getWeatherInformationByCityName("Самара"));
        assertEquals(ExternalServiceWithWeatherData.getWeatherData("Подольск"), Main.getWeatherInformationByCityName("Подольск"));
    }

    @Test
    void testUpdateWeatherDataForACity() {
        assertEquals(new WeatherData(UFA, 16, 94), Main.getWeatherInformationByCityName("Уфа"));

        WeatherData actualUfaWeatherData = new WeatherData(UFA, 17, 88);
        Main.updateWeatherDataForACity(UFA, actualUfaWeatherData);

        assertEquals(actualUfaWeatherData, Main.getWeatherInformationByCityName("Уфа"));
    }

    @Test
    void testDeleteWeatherDataForACity() {
        assertNotNull(WEATHER_DATA_CACHE.get(EKATERINBURG.getName()));
        Main.deleteWeatherDataForACity(EKATERINBURG);
        assertNull(WEATHER_DATA_CACHE.get(EKATERINBURG.getName()));
    }
}