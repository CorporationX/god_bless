package school.faang.main_code;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
}
