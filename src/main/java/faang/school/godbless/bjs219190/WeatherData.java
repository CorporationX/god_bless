package faang.school.godbless.bjs219190;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private float temperature;
    private float humidity;
}
