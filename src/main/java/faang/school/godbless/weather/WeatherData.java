package faang.school.godbless.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public String getWeatherData(){
        return city + ": " + temperature + "\u00B0" + "C, " + humidity + "%";
    }
}
