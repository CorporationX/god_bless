package faang.school.godbless.sprint4.multithreading_parallelism_thread.task11;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10)));

        planRocketLaunches(launches);
    }

    public static void planRocketLaunches(List<RocketLaunch> rocketLaunches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (RocketLaunch rocketLaunch : rocketLaunches) {
            executor.submit(rocketLaunch);
        }
        executor.shutdown();
    }
}
