package faang.school.godbless.catchCatch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class WeatherData {
    private String city;
    private float temp;
    private float humidity;
}
