package school.faang.bjs2_86067;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class WeatherData {

    private City city;
    private double temperature;
    private double humidity;
    private long timestamp;

    @Override
    public String toString() {
        return "WeatherData{" +
                "city=" + city.getCityName() +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}