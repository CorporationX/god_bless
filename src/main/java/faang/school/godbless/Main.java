package faang.school.godbless;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class Main {
    private final Map<String, WeatherData> weatherCache = new HashMap<>();
    private final WeatherService weatherService = new WeatherService();

    public CompletableFuture<WeatherData> getWeatherData(String city) {
        if (this.weatherCache.containsKey(city)) {
            return CompletableFuture.completedFuture(weatherCache.get(city));
        } else {
            return this.weatherService.fetchWeatherData(city)
                    .thenApply(weatherData -> {
                        weatherCache.put(city, weatherData);
                        return weatherData;
                    });
        }
    }

    public CompletableFuture<Void> updateWeatherData(String city) {
        return this.weatherService.fetchWeatherData(city)
                .thenAccept(weatherData -> this.weatherCache.put(city, weatherData));
    }

    public void removeWeatherData(String city) {
        this.weatherCache.remove(city);
    }

    public Set<String> allCities() {
        return this.weatherCache.keySet();
    }
}
