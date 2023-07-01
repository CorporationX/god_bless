package faang.school.godbless.thread.spaceX;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<RocketLaunch> launches = getRocketLaunches();

        long startTime = System.nanoTime();

        planRocketLaunches(launches);

        long endTime = System.nanoTime();

        System.out.println("Total time: " + (endTime - startTime) / 1000000000 + " seconds"); //Total time: 61 seconds
    }

    private static List<RocketLaunch> getRocketLaunches() {
        return List.of(
            new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(10)),
            new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(40)),
            new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(50)),
            new RocketLaunch("Союз 2", LocalDateTime.now().plusMinutes(1))
        );
    }

    private static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            for (RocketLaunch launch : launches) {
                executorService.execute(launch::launch);
            }

            executorService.shutdown();
            executorService.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
