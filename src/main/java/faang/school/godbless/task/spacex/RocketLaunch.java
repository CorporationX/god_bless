package faang.school.godbless.task.spacex;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
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

    public void launch() {
        try {
            System.out.println("Rocket " + name + " prepared to launch");
            Thread.sleep(1000);
            System.out.println("Rocket " + name + " launched at " + launchTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        launches.stream()
                .sorted(Comparator.comparing(RocketLaunch::getLaunchTime))
                .forEach(rocketLaunch -> executorService.execute(rocketLaunch::launch));

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(100, TimeUnit.SECONDS)) {
                System.out.println("All rockets was launched! Spent time: " + (System.currentTimeMillis() - start) + "ms");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 9 v1.0", LocalDateTime.now().plusMinutes(10)),
                new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(20)),
                new RocketLaunch("Falcon 9 v1.1", LocalDateTime.now().plusMinutes(40)),
                new RocketLaunch("Starship", LocalDateTime.now().plusMinutes(55))
        );

        planRocketLaunches(launches);
    }
}
