package faang.school.godbless.Task_9;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeatherData {
    String city;
    Integer temperature;
    Integer humidity;

}
