package school.faang.spring3.task_48320;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(10)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(15)));
        long startTime = System.currentTimeMillis();
        planRocketLaunches(launches);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));

    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            for (RocketLaunch rocket : launches) {
                long delay = Duration.between(LocalDateTime.now(), rocket.getLaunchTime()).toMillis();
                if (delay > 0) {
                    Thread.sleep(delay);
                }
                service.execute(rocket::launch);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("thread was interrupted");
        }
        service.shutdown();
    }
}
