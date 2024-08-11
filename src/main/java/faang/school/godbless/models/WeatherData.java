package faang.school.godbless.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {

    private final String city;
    private float temperature;
    private int humidity;

    @Override
    public String toString() {
        return "In city " + city + " " + String.format("%.2f", temperature) + "C, humidity is " + humidity + "%";
    }
}
