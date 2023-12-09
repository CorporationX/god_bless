package faang.school.godbless.cache;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeatherData {
    String city;
    int temperature;
    int humidity;

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
