package faang.school.godbless.multithreading.spaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class RocketLaunch {
    private String name;
    private LocalDateTime launchTime;
    private static ScheduledExecutorService service;

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " rocket launch");
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        service = Executors.newSingleThreadScheduledExecutor();
        LocalDateTime currentTime;
        LocalDateTime launchTime;

        for (RocketLaunch rocket : launches) {
            currentTime = LocalDateTime.now();
            launchTime = rocket.getLaunchTime();
            long delay = currentTime.until(launchTime, TimeUnit.SECONDS.toChronoUnit());
            if (delay > 1) {
                service.schedule(rocket::launch, delay, TimeUnit.SECONDS);
            } else {
                rocket.launch();
            }
        }
        service.shutdown();
    }

    public static ScheduledExecutorService getService() {
        return service;
    }
}
