package school.faang.bjs248548;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;


class RocketLaunchTest {

    public static final int MILLIS = 7000;

    @Test
    void launch() throws InterruptedException {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("falcon 9", LocalDateTime.now().plusSeconds(1)),
                new RocketLaunch("falcon heavy", LocalDateTime.now().plusSeconds(5)),
                new RocketLaunch("falcon 9 (2)", LocalDateTime.now().plusSeconds(10)),
                new RocketLaunch("falcon 9 lite", LocalDateTime.now().plusSeconds(10)),
                new RocketLaunch("star ship 1", LocalDateTime.now().plusSeconds(11)),
                new RocketLaunch("star ship 2", LocalDateTime.now().plusSeconds(11)),
                new RocketLaunch("star ship 3", LocalDateTime.now().plusSeconds(11))
        );

        RocketLaunch.planRocketLaunches(launches);

        Thread.sleep(MILLIS);
    }
}