package faang.school.godbless.cachingcaching;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;

    @Override
    public String toString() {
        return "Weather in " + city + ": " + temperature + "°C, " + humidity + "% humidity";
    }
}