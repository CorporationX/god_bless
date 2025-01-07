package school.faang.task_51192;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class Sensor {
    private static final long TIMEOUT = 2;
    private static final long INITIAL_DELAY = 0;
    private static final long PERIOD = 1;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final int id;
    private final Substation substation;

    public void startGeneratingData() {
        scheduler.scheduleAtFixedRate(
                () -> {
                    double data = ThreadLocalRandom.current().nextDouble(0.0, 100.0);
                    substation.receiveData(id, data);
                },
                INITIAL_DELAY,
                PERIOD,
                TimeUnit.SECONDS);
        scheduler.schedule(scheduler::shutdown, TIMEOUT, TimeUnit.MINUTES);
    }

    public void stop() {
        scheduler.shutdownNow();
    }
}
