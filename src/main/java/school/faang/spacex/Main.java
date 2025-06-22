package school.faang.spacex;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "Main")
public class Main {

    public static void main(String[] args) {
        var launches = List.of(
                new RocketLaunch("Launch 1", 200),
                new RocketLaunch("Launch 2", 400),
                new RocketLaunch("Launch 3", 600),
                new RocketLaunch("Launch 4", 800),
                new RocketLaunch("Launch 5", 1000)
        );
        benchmark(() -> SpaceCenter.planRocketLaunches(launches));
    }

    private static void benchmark(Runnable action) {
        long start = System.currentTimeMillis();
        action.run();
        long end = System.currentTimeMillis();
        log.info("Общее время выполнения: {}ms", (end - start));
    }
}
