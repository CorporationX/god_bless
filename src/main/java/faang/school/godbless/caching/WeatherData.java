package faang.school.godbless.caching;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
}
