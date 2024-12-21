package school.faang.bjs_48570;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Cleaning {
    private static final int POOL_SIZE = 5;
    private static final int SCHEDULED_PERIOD = 30;

    private final House house;

    public Cleaning(House house) {
        this.house = house;
    }

    public void clean() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(POOL_SIZE);

        List<Runnable> tasks = IntStream.rangeClosed(1, POOL_SIZE)
                .mapToObj(index -> (Runnable) house::collectFood)
                .toList();

        tasks.forEach(task ->
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
    }
}
