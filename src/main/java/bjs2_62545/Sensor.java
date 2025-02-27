package bjs2_62545;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public record Sensor(int id, Substation substation) {
    public static final int INTERVAL_SECONDS = 1;
    public static final int WAITING_TERMINATION_TIMEOUT_MS = 500;

    public Runnable startGeneratingData() {
        var scheduledExecutor = Executors.newScheduledThreadPool(1);

        log.info("Запущен сенсор {}", id);
        var maxValue = id <= 0 ? 1 : id + 1;
        scheduledExecutor.scheduleAtFixedRate(
                () -> {
                    var value = ThreadLocalRandom.current().nextDouble(maxValue);
                    substation.receiveData(id, value);
                },
                0,
                INTERVAL_SECONDS,
                TimeUnit.SECONDS);

        return new ForeverOperationStopper(
                WAITING_TERMINATION_TIMEOUT_MS,
                scheduledExecutor,
                String.format("Остановлен сенсор %d", id));
    }
}
