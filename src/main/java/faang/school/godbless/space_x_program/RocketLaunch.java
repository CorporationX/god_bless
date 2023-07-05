package faang.school.godbless.space_x_program;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class RocketLaunch {
    private String name;
    private LocalDateTime startTime;

    public void launch() {
        System.out.println("Launching " + getName() + " at " + getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The rocket " + getName() + " has been launched");
    }

    public static void planRocketLaunches(List<RocketLaunch> launchList) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (RocketLaunch rocketLaunch : launchList) {
            LocalDateTime now = LocalDateTime.now();
            long duration = Duration.between(now, rocketLaunch.startTime).toMillis();
            try {
                Thread.sleep(duration);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            executorService.submit(rocketLaunch::launch);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

