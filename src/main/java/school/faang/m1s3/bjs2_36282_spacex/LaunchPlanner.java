package school.faang.m1s3.bjs2_36282_spacex;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class LaunchPlanner {
    List<RocketLaunch> launches;

    public void planRocketLaunches() {
        ExecutorService launchService = Executors.newSingleThreadExecutor();
        launches.forEach(launch -> {
            long startTime = System.currentTimeMillis();
            System.out.println("Launch of " + launch.getName() + " starts at " + startTime + " ms");
            while (LocalTime.now().isBefore(launch.getLaunchTime())) {
                System.out.println(LocalTime.now().until(launch.getLaunchTime(), ChronoUnit.SECONDS) + " until start...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error("Thread was interrupted" + e.getMessage(), e);
                }
            }
            launch.launch();

            long endTime = System.currentTimeMillis();
            System.out.println("Launch of " + launch.getName() + " ended at " + endTime + " ms");
            System.out.println("Process took " + (endTime - startTime) + " ms");
            System.out.println();
        });
        launchService.shutdown();

        try {
            if (!launchService.awaitTermination(5, TimeUnit.MINUTES)) {
                launchService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread was interrupted" + e.getMessage(), e);
        }
    }
}
