package faang.school.godbless.Caching;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    String city;
    int temperature;
    int humidity;   //влажность

    @Override
    public String toString() {
        return city + ", temperature " + temperature +
                ", humidity " + humidity;
    }
}
