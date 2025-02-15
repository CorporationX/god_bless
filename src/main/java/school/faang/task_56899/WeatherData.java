package school.faang.task_56899;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class WeatherData {
    @NonNull
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;
}
