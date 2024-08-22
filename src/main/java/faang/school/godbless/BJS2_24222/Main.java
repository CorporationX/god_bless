package faang.school.godbless.BJS2_24222;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        List<RocketLaunch> rocketLaunches = List.of(
                new RocketLaunch("Falcon 1", new LocalDateTimeForRocket(now.plusSeconds(10))),
                new RocketLaunch("Falcon 2", new LocalDateTimeForRocket(now.plusSeconds(20))),
                new RocketLaunch("Falcon 3", new LocalDateTimeForRocket(now.plusSeconds(30))),
                new RocketLaunch("Falcon 4", new LocalDateTimeForRocket(now.plusSeconds(40))),
                new RocketLaunch("Falcon 5", new LocalDateTimeForRocket(now.plusMinutes(1)))
        );

        long timeSpent = RocketLaunch.planRocketLaunches(rocketLaunches);
        System.out.println("Затраченное время на запуск всех ракет: " + timeSpent);
    }
}
