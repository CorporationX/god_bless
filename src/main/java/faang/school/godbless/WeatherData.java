package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class WeatherData {
    private String city;
    private double temperature;
    private int humidity;

    public WeatherData(String city,double temperature, int humidity)
    {
        this.city = city;
        this.temperature = temperature;
        this.humidity =humidity;
    }
}
