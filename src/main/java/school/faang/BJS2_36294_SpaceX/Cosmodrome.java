package school.faang.BJS2_36294_SpaceX;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Cosmodrome {
    private static final int AWAIT_TERMINATION_TIME = 12_000;

    private ExecutorService executor;

    public Cosmodrome() {
        executor = Executors.newSingleThreadExecutor();
    }

    public void planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();

        launches.forEach(launch ->
                executor.submit(() -> {
                    launch.launch();
                    try {
                        Thread.sleep(launch.getLaunchTime());
                    } catch (InterruptedException e) {
                        log.error(
                                "Thread {} was interrupted while the launch time of Rocket {}",
                                Thread.currentThread().getName(), launch.getName(), e
                        );
                    }
                })
        );

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error(
                    "Thread {} was interrupted while waiting for launched to finish! Shutting down executor!",
                    Thread.currentThread().getName()
            );
        }

        long endTime = System.currentTimeMillis();
        log.info("Execution time of planRocketLaunches: {} ms", (endTime - startTime));
    }
}
