package faang.school.godbless.WeatherData;


import lombok.Data;

@Data
public class WeatherData {
    private String city;
    private Float temperature;
    private Float humidity;

    public WeatherData(String city, Float temperature, Float humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }


    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
