package faang.school.godbless.caching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {

    private String city;
    private double temperature;
    private double humidity;

}
