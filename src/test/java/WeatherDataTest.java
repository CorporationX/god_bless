import hashmap.cashing.WeatherData;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeatherDataTest {
    @Test
    @DisplayName("Create WeatherData with null arguments")
    void weatherDataTest_createDataWithNullArguments() {
        assertThrows(NullPointerException.class, () -> new WeatherData(null, 1, 1));
    }
}
