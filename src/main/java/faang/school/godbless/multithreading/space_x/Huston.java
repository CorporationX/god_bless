package faang.school.godbless.multithreading.space_x;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Huston {
    public static void main(String[] args) {
        new Huston().planRocketLaunches();
    }
    public void planRocketLaunches() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        long start = System.currentTimeMillis();

        getRocketLaunches().forEach(executor::submit);
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private List<RocketLaunch> getRocketLaunches() {
        return List.of(
                new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)),
                new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5)),
                new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10))
        );
    }
}
