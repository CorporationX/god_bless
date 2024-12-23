package school.faang.sprint3.task_48392;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RocketLaunchManager launchManager = new RocketLaunchManager();

        RocketLaunch r1 = new RocketLaunch("falcon 9", LocalDateTime.now().plusSeconds(2));
        RocketLaunch r2 = new RocketLaunch("falcon 10", LocalDateTime.now().plusSeconds(5));
        long lastTimeInMillis = System.currentTimeMillis();
        launchManager.planRocketLaunches(List.of(r1, r2));
        System.out.println("Rocket launch timing " + (System.currentTimeMillis() - lastTimeInMillis));

    }
}
