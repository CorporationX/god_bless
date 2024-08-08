package faang.school.godbless.BJS2_18865;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class WeatherData {
    private String city;
    private float temperature;
    private float humidity;

    @Override
    public String toString() {
        return "WeatherData [city=" + city + ", temperature=" + temperature + ", humidity= " + humidity + "]";
    }

}
