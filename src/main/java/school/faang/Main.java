package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<RocketLaunch> launches = Arrays.asList(new RocketLaunch("second", LocalDateTime.now().plusSeconds(10)),
                new RocketLaunch("first", LocalDateTime.now().plusSeconds(5)));
        long startTime = System.currentTimeMillis();
        RockerLaunchService.planRockerLaunches(launches);
        logger.info("Total execution time: {} ms.", System.currentTimeMillis() - startTime);
    }
}
