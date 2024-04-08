package faang.school.godbless.cashe;

public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

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

