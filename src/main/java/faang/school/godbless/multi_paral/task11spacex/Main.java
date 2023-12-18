package faang.school.godbless.multi_paral.task11spacex;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 1", System.currentTimeMillis() + 5000),
                new RocketLaunch("Falcon 9", System.currentTimeMillis() + 10000),
                new RocketLaunch("Starship", System.currentTimeMillis() + 15000)
        );

        long timeSpent = planRocketLaunches(launches);
        System.out.println("Время потраченное на запуски: " + timeSpent + " ms");
    }
    public static long planRocketLaunches(List<RocketLaunch> launches) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        long startTime = System.currentTimeMillis();

        for (RocketLaunch launch : launches) {
            executor.submit(() -> {
                long delay = launch.getTime() - System.currentTimeMillis();
                delay = Math.max(delay, 0); // на всякий случай
                try {
                    Thread.sleep(delay);
                    launch.launch();
                } catch (InterruptedException e) {
                    System.out.println("Запуск прерван");
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
