package faang.school.godbless.BJS2_4715;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;
}
