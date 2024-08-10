package faang.school.godbless.BJS2_19021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class WeatherDataTest {
    Map<String, WeatherData> map;
    WeatherData weatherData;

    @BeforeEach
    void setUp() {
        weatherData = new WeatherData();
        map = new HashMap<>(Map.copyOf(Application.getWeatherCache()));
        map.put("Moscow", new WeatherData("Moscow", 24, 60));
        map.put("Saint-Petersburg", new WeatherData("Saint-Petersburg", 19, 70));
    }

    @Test
    void getDataFromCache() {
        var givenData = new WeatherData("Moscow", 24, 60);
        var result = weatherData.getDataFromCache("Moscow", map);

        assertThat(givenData).isEqualTo(result);

    }

    @Test
    void getWeatherDataFromCacheShouldDoRequest() {
        weatherData.getDataFromCache("London", map);

        assertThat(map).hasSize(3);
        assertThat(map).containsKey("London");
    }

    @Test
    void updateWeatherData() {
        weatherData.updateWeatherData("Saint-Petersburg", map,
                30, 50);

        assertThat(map.get("Saint-Petersburg")).isEqualTo(new WeatherData("Saint-Petersburg", 30, 50));
    }

    @Test
    void removeWeatherData() {
        weatherData.removeWeatherData("Moscow", map);
        assertThat(map).hasSize(1);
        assertThat(map).doesNotContainKey("Moscow");
    }
}