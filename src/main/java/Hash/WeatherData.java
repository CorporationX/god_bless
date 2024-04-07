package Hash;

import lombok.Value;

@Value
public class WeatherData {
    String city;
    int temperature;
    int humidity;
}
