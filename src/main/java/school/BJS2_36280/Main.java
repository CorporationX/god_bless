package school.BJS2_36280;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(1)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(2)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(4)));

        long startTime = System.currentTimeMillis();
        planRocketLaunches(launches);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Разница во времени в миллисекундах: " + duration);
    }

    private static void planRocketLaunches(List<RocketLaunch> launches) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (RocketLaunch launch : launches) {
            LocalDateTime wakeUp = launch.getLaunchTime();
            LocalDateTime now = LocalDateTime.now();
            long sleep = Duration.between(now, wakeUp).toMillis();
            System.out.println("К запуску готова ракета: " + launch.getName());
            Thread.sleep(sleep);
            executorService.execute(() -> {
                try {
                    launch.launch();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}