package school.faang.SpaceX;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketLauncher {

    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch launch : launches) {
            long delay = launch.getLaunchTime() - System.currentTimeMillis();
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            executor.submit(launch::launch);
        }

        executor.shutdown();

        long startTime = System.currentTimeMillis();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.err.println("Не все задачи завершились вовремя! Принудительное завершение.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Прерывание во время ожидания завершения задач.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения: %s мс%n", (endTime - startTime));
    }
}