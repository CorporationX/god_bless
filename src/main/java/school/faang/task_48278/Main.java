package school.faang.task_48278;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();

        launches.add(new RocketLaunch("Falcon 9", System.currentTimeMillis() + 1000));
        launches.add(new RocketLaunch("Atlas V", System.currentTimeMillis() + 3000));
        launches.add(new RocketLaunch("Soyuz", System.currentTimeMillis() + 4000));
        launches.add(new RocketLaunch("Ariane 5", System.currentTimeMillis() + 5000));
        launches.add(new RocketLaunch("Delta IV", System.currentTimeMillis() + 6000));

        long start = System.currentTimeMillis();
        planRocketLaunches(launches);
        long end = System.currentTimeMillis();
        long executionTime = end - start;
        System.out.printf("Время выполнения метода planRocketLaunches: %d миллисекунд\n", executionTime);


    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (RocketLaunch rocketLaunch : launches) {
            executorService.submit(rocketLaunch::launch);
        }
        executorService.shutdown();
    }

}
