package faang.school.godbless.cashing;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WeatherData {

    private String city;
    private int temperature;
    private int humidity;

    // Конструктор класса WeatherData
    public WeatherData(String city, int temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
