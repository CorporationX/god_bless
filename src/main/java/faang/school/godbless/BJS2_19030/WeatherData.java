package faang.school.godbless.BJS2_19030;

import java.util.Objects;

public class WeatherData {
    private String city;
    private double temperature;
    private int humidity;

    public WeatherData(String city, double temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return Double.compare(temperature, that.temperature) == 0 && humidity == that.humidity && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, humidity);
    }

    @Override
    public String toString() {
        return
                "city='" + city + '\'' +
                        ", temperature=" + temperature +
                        ", humidity=" + humidity;
    }
}
