package faang.school.godbless;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherService {
    private final static int QUEUE_SIZE = 1;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(QUEUE_SIZE);

    public CompletableFuture<WeatherData> fetchWeatherData(String city) {
        CompletableFuture<WeatherData> future = new CompletableFuture<>();

        this.scheduler.schedule(() -> {
            future.complete(new WeatherData(city, Math.random() * 40, Math.random() * 100));
        }, 3, TimeUnit.SECONDS);

        return future;
    }
}
