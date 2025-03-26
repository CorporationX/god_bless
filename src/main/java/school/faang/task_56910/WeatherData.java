package school.faang.task_56910;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeatherData {
    String city;
    double temperature;
    double humidity;
    long timestamp;

}
