package faang.school.godbless.spaceX;

import ch.qos.logback.core.pattern.color.WhiteCompositeConverter;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class LaunchManager {
    private List<RocketLaunch> launches;
    private ScheduledExecutorService service;
    public static void main(String[] args) {
        LaunchManager manager = new LaunchManager(
                List.of(
                        new RocketLaunch("1", new Date(new Date().getTime() + 1000)),
                        new RocketLaunch("2", new Date(new Date().getTime() + 2000)),
                        new RocketLaunch("3", new Date(new Date().getTime() + 3000)),
                        new RocketLaunch("4", new Date(new Date().getTime() + 4000)),
                        new RocketLaunch("5", new Date(new Date().getTime() + 5000)),
                        new RocketLaunch("6", new Date(new Date().getTime() + 6000)),
                        new RocketLaunch("7", new Date(new Date().getTime() + 7000))
                        ),
                Executors.newSingleThreadScheduledExecutor()
        );
        manager.planRocketLaunches();
    }

    public void planRocketLaunches() {
        long start = (new Date()).getTime();

        for (RocketLaunch launch : launches) {
            service.schedule(launch::launch,
                    launch.getLaunchTime().getTime() - (new Date()).getTime(), TimeUnit.MILLISECONDS);
        }

        service.shutdown();

        while (!service.isTerminated()){}
        long end = (new Date()).getTime();
        System.out.println("время работы: " + (end - start) + " millis");
    }
}
