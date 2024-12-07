package school.faang.task_44845.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherData {
    String city;
    double temperature;
    double humidity;
    long timestamp;
}
