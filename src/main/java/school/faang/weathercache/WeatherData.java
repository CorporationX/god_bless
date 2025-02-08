package school.faang.weathercache;

import lombok.Getter;

public record WeatherData(String city, double temperature, double humidity, long timestamp) {
}
