package school.faang.sprint3.task_48392;

import lombok.SneakyThrows;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RocketLaunchManager {

    @SneakyThrows
    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        launches.forEach(launch -> {
            Duration duration = Duration.between(LocalDateTime.now(), launch.getLaunchTime());
            long milliSeconds = duration.getSeconds() * 1000;
            System.out.println("delay time: " + milliSeconds);
            try {
                Thread.sleep(milliSeconds);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            executorService.submit(launch::launch);
        });
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1);
        }
    }
}
