package school.faang.BJS232615;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private final double temperature;
    private final double humidity;
}
