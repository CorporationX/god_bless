package school.faang.cashe.cache;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private Double temperature;
    private Double humidity;
}
