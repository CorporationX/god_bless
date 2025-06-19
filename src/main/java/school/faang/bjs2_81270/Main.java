package school.faang.bjs2_81270;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    private static final int ROCKET_COUNT = 5;
    private static final long MIN_BOUND = 1_000;
    private static final long MAX_BOUND = 10_000;

    private static RocketLaunchManager manager = new RocketLaunchManager();

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>(ROCKET_COUNT);
        for (int i = 1; i <= ROCKET_COUNT; i++) {
            launches.add(new RocketLaunch("Rocket-" + i, ThreadLocalRandom.current().nextLong(MIN_BOUND, MAX_BOUND)));
        }

        long startTime = System.currentTimeMillis();

        manager.planRocketLaunches(launches);

        long endTime = System.currentTimeMillis();
        log.info("Время запуска всех ракет {}ms", endTime - startTime);
    }
}
