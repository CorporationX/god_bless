package faang.school.godbless.sprint_3.multithreading.space_x_program;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RocketLaunch {
    private String launchName;
    private LocalDateTime startTime;

    public void launch() {
        System.out.printf("Ракета с именем: %s готовится к запуску!%n", launchName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.printf("Ракета с именем: %s запущена!%n", launchName);
    }

    public void planRocketLaunches(List<RocketLaunch> list) {
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            for (RocketLaunch rocketLaunch : list) {
                LocalDateTime now = LocalDateTime.now();
                Duration duration = Duration.between(now, rocketLaunch.getStartTime());
                long milliseconds = duration.toMillis();
                try {
                    Thread.sleep(milliseconds);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                executor.submit(rocketLaunch::launch);
            }
        }
    }
}
