package school.faang.caching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherServiceTest {

    private WeatherProvider weatherProvider;

    @BeforeEach
    public void setUp() {
        weatherProvider = new WeatherService();
    }

    @Test
    @DisplayName("Извлечение данных о погоде в конкретном городе")
    public void testFetchWeatherData() {
        String moscow = "Moscow";

        WeatherData weatherData = weatherProvider.fetchWeatherData(moscow);

        assertThat(weatherData).isNotNull();
        assertThat(weatherData.getCity()).isEqualTo(moscow);
        assertThat(weatherData.getHumidity()).isBetween(0.0, 1.0);
        assertThat(weatherData.getTemperature()).isBetween(-35.0, 35.0);
        assertThat(weatherData.getTimestamp()).isLessThan(System.currentTimeMillis());
    }
}
