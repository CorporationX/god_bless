package school.faang.spaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class RocketLaunch {
    private String name;
    private LocalDateTime launchTime;

    @SneakyThrows
    public void launch() {
        Thread.sleep(1000);
        System.out.println("The rocket has launched: " + name);
    }

    public static void planRocketLaunch(List<RocketLaunch> launches) {
        launches.sort(Comparator.comparing(RocketLaunch::getLaunchTime));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (RocketLaunch launch : launches) {
            executor.submit(() -> {
                LocalDateTime currentTime = LocalDateTime.now();
                long delay = currentTime.until(launch.getLaunchTime(), ChronoUnit.MILLIS);

                if (delay > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(delay);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                launch.launch();
            });
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
                System.out.println("Some tasks failed to complete in time.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
