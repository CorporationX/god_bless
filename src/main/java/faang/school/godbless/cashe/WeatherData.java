package faang.school.godbless.cashe;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class WeatherData {
    protected String city;
    protected int temperature;
    protected int humidity;

    public WeatherData(String city, int temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "city: " + city + ", temperature: " + temperature + ", humidity: " + humidity;
    }
}

