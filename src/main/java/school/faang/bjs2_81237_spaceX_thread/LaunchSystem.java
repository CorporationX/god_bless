package school.faang.bjs2_81237_spaceX_thread;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LaunchSystem {
    public static final int LAUNCH_THREAD_TICK_SECONDS = 10;

    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Omega", LocalDateTime.now().plusSeconds(5)),
                new RocketLaunch("Orion", LocalDateTime.now().plusSeconds(15)),
                new RocketLaunch("Nebula", LocalDateTime.now().plusSeconds(25)),
                new RocketLaunch("Galaxy", LocalDateTime.now().plusSeconds(35))
        );

        planRocketLaunches(launches);
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();
        List<RocketLaunch> toLaunch = Collections.synchronizedList(new ArrayList<>(launches));
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            while (!toLaunch.isEmpty()) {
                log.info("Checking for scheduled launches.");
                Optional<RocketLaunch> nextLaunchOptional = toLaunch.stream()
                        .filter(l -> LocalDateTime.now().isAfter(l.getLaunchDateTime()))
                        .limit(1)
                        .findFirst();

                if (nextLaunchOptional.isEmpty()) {
                    log.info("No launches scheduled to launch, sleeping.");
                    try {
                        TimeUnit.SECONDS.sleep(LAUNCH_THREAD_TICK_SECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                } else {
                    log.info("Found a ready launch {}", nextLaunchOptional.get().getName());
                    toLaunch.remove(nextLaunchOptional.get());
                    try {
                        nextLaunchOptional.get().launch();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        executorService.shutdown();
        try {
            boolean allLaunched = executorService.awaitTermination(10, TimeUnit.MINUTES);
            if (allLaunched) {
                log.info("Executor shut down, no more launches to process");
            } else {
                log.error("Some launches could not finish before executor termination");
            }
            long endTime = System.currentTimeMillis();
            log.info(
                    "Total launches execution took {} seconds.",
                    TimeUnit.MILLISECONDS.toSeconds(endTime - startTime)
            );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Waiting for executor termination interrupted");
            throw new RuntimeException(e);
        }

    }
}
