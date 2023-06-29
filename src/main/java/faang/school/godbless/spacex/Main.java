package faang.school.godbless.spacex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RocketLaunch rocketLaunch = new RocketLaunch();
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(2)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(10)));

        long start = System.currentTimeMillis();
        rocketLaunch.planRocketLaunches(launches);
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println(result);
    }
}
