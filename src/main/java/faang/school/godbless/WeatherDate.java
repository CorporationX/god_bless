package faang.school.godbless;

import java.util.Objects;

public class WeatherDate {
    private String city;
    private int temperature, humidity;

    public WeatherDate(String city, int temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return  " temperature = " + temperature +
                ", humidity = " + humidity;
    }
}
