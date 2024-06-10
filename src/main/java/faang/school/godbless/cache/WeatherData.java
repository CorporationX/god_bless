package faang.school.godbless.cache;

public class WeatherData {
    private String city;
    private Integer temperature;
    private Integer humidity;

    public WeatherData(String city, Integer temperature, Integer humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}
