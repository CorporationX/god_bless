package Multithreading.bc2409;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(10)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusSeconds(15)));

        RocketLaunch.planRocketLaunches(launches);
    }
}
