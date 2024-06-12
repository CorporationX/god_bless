package faang.school.godbless.CacheCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WeatherService {
    private static Map<String, WeatherService> weatherOfCity = new HashMap<>();

    private String city;
    private int temperature;
    private int humidity;

    public static WeatherService getForecast(String city) {
        WeatherControlCenter();
        return weatherOfCity.get(city);
    }

    public static void WeatherControlCenter() {
        weatherOfCity.put("Saint-Petersburg", new WeatherService("Saint-Petersburg", 10 + (int) (Math.random() * 10), 30 + (int) (Math.random() * 65)));
        weatherOfCity.put("Moscow", new WeatherService("Moscow", 10 + (int) (Math.random() * 10), 30 + (int) (Math.random() * 65)));
        weatherOfCity.put("Amsterdam", new WeatherService("Amsterdam", 10 + (int) (Math.random() * 10), 30 + (int) (Math.random() * 65)));
    }

    public WeatherService(String city, int temperature, int humidity) {
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
            WeatherService weatherService = (WeatherService) o;
            return this.city == weatherService.city && this.temperature == weatherService.temperature && this.humidity == weatherService.humidity;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.city, this.temperature, this.humidity);
    }
}
