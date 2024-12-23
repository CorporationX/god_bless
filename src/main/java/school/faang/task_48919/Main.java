package school.faang.task_48919;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LaunchingSystem launchingSystem = new LaunchingSystem();
        RocketLaunch rocket1 = new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(2));
        RocketLaunch rocket2 = new RocketLaunch("Falcon 10", LocalDateTime.now().plusSeconds(3));

        long lastTimeMillis = System.currentTimeMillis();
        launchingSystem.planRocketLaunches(List.of(rocket1, rocket2));
        System.out.printf("Executed in: %s millis", System.currentTimeMillis() - lastTimeMillis);
    }
}
