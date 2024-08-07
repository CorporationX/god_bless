package hashmap.cashing;

import lombok.Data;
import lombok.NonNull;

@Data
public class WeatherData {
    @NonNull
    private final String city;
    private final int temperature;
    private final int humidity;
}
