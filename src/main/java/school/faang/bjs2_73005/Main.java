package school.faang.bjs2_73005;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    private static final RocketStation ROCKET_STATION = new RocketStation();
    private static final int ROCKET_LAUNCH_TIME = 10000;
    private static final int THIRD_ROCKET_LAUNCH_TIME = 15000;

    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 9", System.currentTimeMillis() + ROCKET_LAUNCH_TIME),
                new RocketLaunch("Falcon Heavy", System.currentTimeMillis() + ROCKET_LAUNCH_TIME),
                new RocketLaunch("Dragon", System.currentTimeMillis() + THIRD_ROCKET_LAUNCH_TIME)
        );
        long before = System.currentTimeMillis();
        ROCKET_STATION.planRocketLaunches(launches);
        log.info("Execution time: {}", System.currentTimeMillis() - before);
    }
}