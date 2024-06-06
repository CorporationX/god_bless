package faang.school.godbless.module1.sprint1.task10;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;
}
