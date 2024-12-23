package school.faang.task_48919;

import lombok.SneakyThrows;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LaunchingSystem {

    @SneakyThrows
    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        launches.forEach(launch -> {
            Duration duration = Duration.between(LocalDateTime.now(), launch.getLaunchTime());
            long millis = duration.getSeconds() * 1000;
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            executorService.submit(launch::launchRocket);
        });
        executorService.shutdown();
        Thread.sleep(2000);
        while (!executorService.isTerminated()) {
            executorService.shutdownNow();
        }

    }
}
