package school.faang.bjs2_56865;

import lombok.Value;

@Value
public class WeatherData {
    String city;
    double temperature;
    double humidity;
    long timestamp;
}
