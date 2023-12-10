package faang.school.godbless.cache;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
