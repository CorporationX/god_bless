package school.faang.spacex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch launch : launches) {
            executor.submit(launch::launch);
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(200, TimeUnit.SECONDS)) {
                System.out.println("Программа завершена");
            } else {
                System.out.println("Программа завершена принудительно");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(10)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(20)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(30)));

        long start = System.currentTimeMillis();

        planRocketLaunches(launches);

        System.out.println("Метод planRocketLaunches() выполнялся " + (System.currentTimeMillis() - start) + " мс");
    }
}