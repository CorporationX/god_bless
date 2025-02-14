package school.faang.cachecache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class WeatherData {
    @NonNull
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;
}
