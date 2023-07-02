package faang.school.godbless.multithreading.spaceX;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(10)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(2)));
        long start = System.currentTimeMillis();
        RocketLaunch.planRocketLaunches(launches);
        long end = System.currentTimeMillis();
        RocketLaunch.getService().shutdown();
        RocketLaunch.getService().awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Time taken to execute the method: 12" + (end - start));
    }
}
