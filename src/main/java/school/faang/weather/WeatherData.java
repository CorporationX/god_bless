package school.faang.weather;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private Double temperature;
    private Double humidity;
    private Long timestamp;
}
