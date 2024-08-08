package faang.school.godbless.Mathew;

import lombok.Data;
import lombok.ToString;

@ToString
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public WeatherData(String city) {
        this.city = city;
        this.temperature = (int) (Math.random() * 50);
        this.humidity = (int) (Math.random() * 100);
    }
}
