package faang.school.godbless.java.sql.cache;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherData {
    private String city;
    private float temperature;
    private float humidity;

    public void setAllParams(String city, float temperature, float humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
