package school.faang.Multithreading.sprint_3;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        RocketLaunch rocketLaunch = new RocketLaunch();
        List<RocketLaunch> launches = Arrays.asList(
//                new RocketLaunch("Сфера", LocalTime.now().plusSeconds(5).getSecond() * 1000),
                new RocketLaunch("Звезда", LocalTime.now().plusSeconds(2)),
                new RocketLaunch("Победа", LocalTime.now().plusSeconds(15)),
                new RocketLaunch("Солнце", LocalTime.now().plusSeconds(5))
        );

        rocketLaunch.planRocketLaunches(launches);

    }
}
