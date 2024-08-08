package faang.school.godbless.Weather;

import lombok.Getter;

@Getter
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;

    public WeatherData(String city, double temperature, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }


    @Override
    public String toString() {
        return "City: " + city + ", Temperature: " + temperature + "°C, Humidity: " + humidity + "%";
    }
}
