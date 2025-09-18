package school.faang.bjs2_89747;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(2)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(3)));
        RocketLaunchService rocketLaunchService = new RocketLaunchService();
        long startTime = System.currentTimeMillis();
        rocketLaunchService.planRocketLaunches(launches);
        long endTime = System.currentTimeMillis();
        log.info("Total execution time: {} ms", endTime - startTime);
    }
}
