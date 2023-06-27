package faang.school.godbless.spacex;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@AllArgsConstructor
public class RocketLaunch {

    private String launchName;
    private LocalDateTime launchTime;

    public static void planRocketLaunches(List<RocketLaunch> launchPlan) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (RocketLaunch rocketLaunch : launchPlan) {
            Duration delay = Duration.between(LocalDateTime.now(), rocketLaunch.getLaunchTime());

            executorService.submit(() -> {
                try {
                    Thread.sleep(delay.toMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rocketLaunch.launch();
            });
        }

        executorService.shutdown();
    }

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Rocket launch: " + launchName + " at " + launchTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
