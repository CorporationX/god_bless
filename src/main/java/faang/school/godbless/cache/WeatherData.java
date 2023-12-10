package faang.school.godbless.cache;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;
}
