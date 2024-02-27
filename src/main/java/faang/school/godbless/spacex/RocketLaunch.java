package faang.school.godbless.spacex;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class RocketLaunch {

    private String name;
    private LocalDateTime launchTime;

    public void launch() {
        sleep();
        System.out.println(String.format("Rocket \"%s\" successfully launched at %s", name, LocalDateTime.now()));
    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        rocketLaunches.forEach(rocketLaunch -> {
            long delay = rocketLaunch.getDelay();
            executorService.schedule(rocketLaunch::launch, delay, TimeUnit.SECONDS);
        });
        executorService.shutdown();
        awaitTermination(executorService);
    }

    private long getDelay() {
        return LocalDateTime.now().until(launchTime, ChronoUnit.SECONDS);
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void awaitTermination(ExecutorService executorService) {
        try {
            executorService.awaitTermination(5L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
