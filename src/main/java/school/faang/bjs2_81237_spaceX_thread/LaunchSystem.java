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

import static school.faang.utils.ThreadUtils.gracefulShutdown;

@Slf4j
public class LaunchSystem {
    public static final int LAUNCH_THREAD_TICK_SECONDS = 10;
    public static final int AWAIT_SERVICE_SHUTDOWN_MINUTES = 10;

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
                Optional<RocketLaunch> nextLaunchOptional = getNextLaunch(toLaunch);

                if (nextLaunchOptional.isEmpty()) {
                    log.info("No launches scheduled to launch, sleeping.");
                    waitForNextTick();
                } else {
                    log.info("Found a ready launch {}", nextLaunchOptional.get().getName());
                    doLaunch(nextLaunchOptional.get());
                    toLaunch.remove(nextLaunchOptional.get());
                }
            }
        });

        gracefulShutdown(
                executorService,
                AWAIT_SERVICE_SHUTDOWN_MINUTES,
                () -> {
                    long endTime = System.currentTimeMillis();
                    log.info(
                            "Total launches execution took {} seconds.",
                            TimeUnit.MILLISECONDS.toSeconds(endTime - startTime)
                    );
                });
    }

    private static void doLaunch(RocketLaunch rocketLaunch) {
        try {
            rocketLaunch.launch();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static void waitForNextTick() {
        try {
            TimeUnit.SECONDS.sleep(LAUNCH_THREAD_TICK_SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static Optional<RocketLaunch> getNextLaunch(List<RocketLaunch> toLaunch) {
        return toLaunch.stream()
                .filter(LaunchSystem::isReadyToLaunch)
                .findFirst();
    }

    private static boolean isReadyToLaunch(RocketLaunch launch) {
        return LocalDateTime.now().isAfter(launch.getLaunchDateTime());
    }


}
