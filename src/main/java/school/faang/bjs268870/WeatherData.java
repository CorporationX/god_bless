package school.faang.bjs268870;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WeatherData {

    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
