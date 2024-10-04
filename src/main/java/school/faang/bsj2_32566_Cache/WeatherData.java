package school.faang.bsj2_32566_Cache;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private final String city;
    private double temperature;
    private double humidity;
}
