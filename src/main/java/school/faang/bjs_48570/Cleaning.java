package school.faang.bjs_48570;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Cleaning {
    private static final int POOL_SIZE = 5;
    private static final int SCHEDULED_PERIOD = 10;

    private final House house;

    public Cleaning(House house) {
        this.house = house;
    }

    public void clean() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(POOL_SIZE);
        Runnable task = house::collectFood;

        IntStream.range(0, POOL_SIZE).forEach(i ->
                executorService.scheduleAtFixedRate(task, 0, SCHEDULED_PERIOD, TimeUnit.SECONDS)
        );


        while (!house.isClean()) {
            try {
                Thread.sleep(SCHEDULED_PERIOD);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }

        log.info("Clean completed");
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Clean interrupted");
        }
    }
}
