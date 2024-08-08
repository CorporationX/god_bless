package faang.school.godbless;

import java.util.concurrent.*;

public class WeatherService {
    public CompletableFuture<WeatherData> fetchWeatherData(String city) {
        return CompletableFuture.supplyAsync(() -> {
            return new WeatherData(city, Math.random() * 40, Math.random() * 100);
        });
    }
}
