package faang.school.godbless.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class RocketLaunch {
    private String nameLaunch;
    private LocalDateTime localDateTime;

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(nameLaunch + " has launch");
    }

    public void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        for (RocketLaunch launch : rocketLaunches) {
            long delay = LocalDateTime.now().until(launch.getLocalDateTime(), ChronoUnit.MINUTES);
            executor.schedule(launch::launch, delay, TimeUnit.SECONDS);
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10)));

        for (RocketLaunch launch : launches) {
            launch.planRocketLaunches(launches);
        }
    }
}
