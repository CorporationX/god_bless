package faang.school.godbless.cachecache;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WeatherData {
    private String city;
    private double temperature;
    private int humidity;
}
