package school.faang.task_48919;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LaunchingSystem {

    public void planRocketLaunches(List<RocketLaunch> launches) {
        List<RocketLaunch> mutableLaunches = new ArrayList<>(launches);
        mutableLaunches.sort(Comparator.comparing(RocketLaunch::getLaunchTime));

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch launch : launches) {
            long delay = ChronoUnit.MILLIS.between(LocalDateTime.now(), launch.getLaunchTime());
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println("Ожидание прервано!");
                }
            }

            executor.submit(launch::launchRocket);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(15, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершены!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка при завершении пула потоков!");
            executor.shutdownNow();
        }
    }
}