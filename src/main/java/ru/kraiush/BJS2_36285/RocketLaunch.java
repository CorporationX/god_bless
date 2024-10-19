package ru.kraiush.BJS2_36285;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private LocalDateTime launchTime;

    private void launch() {
        try {
            Thread.sleep(1000);
            System.out.println("The rocket " + name + " is launching...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        List<RocketLaunch> orderedLaunches = launches.stream()
                .sorted(Comparator.comparing(RocketLaunch::getLaunchTime))
                .toList();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long startTime = System.currentTimeMillis();
        for (RocketLaunch rocket : orderedLaunches) {
            executorService.submit(() -> {
                long waitTime = rocket.getLaunchTimeInMillis() - System.currentTimeMillis();
                try {
                    if (waitTime > 0) {
                        Thread.sleep(waitTime);
                    }
                    rocket.launch();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                long endTime = System.currentTimeMillis();
                System.out.println("Launching all rockets took " + (endTime - startTime) + " mls");
            }
        } catch (InterruptedException e) {
            System.out.println("Launches failed!");
        }
    }

    private long getLaunchTimeInMillis() {
        return launchTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
