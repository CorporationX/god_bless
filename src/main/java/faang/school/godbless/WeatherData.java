package faang.school.godbless;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;

    @Override
    public String toString() {
        return "WeatherData { " +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                " }";
    }
}
