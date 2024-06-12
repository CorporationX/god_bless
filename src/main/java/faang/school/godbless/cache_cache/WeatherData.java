package faang.school.godbless.cache_cache;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private float temperature;
    private int humidity;
}
