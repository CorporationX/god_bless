package module_1.module_1_2_HashMap.cacheCache;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private final String city;
    private final int temperature;
    private final int humidity;

}
