package faang.school.godbless.parallelismAndThread.spaceX;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestLaunch {

    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(10)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(30)));

        RocketStarter rocketStarter = new RocketStarter();

        long startTime = System.currentTimeMillis();
        rocketStarter.planRocketLaunches(launches);
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endTime - startTime));
    }
}
