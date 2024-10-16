package school.faang.Multithreading.sprint_3;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RocketLaunch rocketLaunch = new RocketLaunch();
        List<RocketLaunch> launches = Arrays.asList(
                new RocketLaunch("Сфера", LocalDateTime.now().plusMinutes(1)),
                new RocketLaunch("Звезда", LocalDateTime.now().plusMinutes(1)),
                new RocketLaunch("Победа", LocalDateTime.now().plusMinutes(1)),
                new RocketLaunch("Солнце", LocalDateTime.now().plusMinutes(1))
        );
        rocketLaunch.planRocketLaunches(launches);
    }
}
