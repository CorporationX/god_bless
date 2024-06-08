package faang.school.godbless;

import java.util.Objects;

public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public WeatherData(String city, int temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return this.city;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getHumidity() {
        return this.humidity;
    }

    @Override
    public String toString() {
        return "|" + this.city + "| temperature: " + this.temperature + " humidity: " + this.humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (this.getClass() != o.getClass() || o == null) return false;
        else {
            WeatherData weatherData = (WeatherData) o;
            return this.city == weatherData.city && this.temperature == weatherData.temperature && this.humidity == weatherData.humidity;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.city, this.temperature, this.humidity);
    }
}