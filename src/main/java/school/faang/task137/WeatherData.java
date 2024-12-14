package school.faang.task137;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WeatherData {

    private String city;
    private int temperature;
    private double humidity;
}
