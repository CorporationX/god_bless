package school.faang.sprint_3.task_48249;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int AMOUNT_OF_LAUNCHES = 10;
    private static final int LAUNCH_TIME_GENERATOR = 1000;

    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = new ArrayList<>();

        for (int i = 1; i <= AMOUNT_OF_LAUNCHES; i++) {
            rocketLaunches.add(new RocketLaunch("Launch " + i, i * LAUNCH_TIME_GENERATOR));
        }

        LaunchPlanner launchPlanner = new LaunchPlanner();
        long startPlanning = System.currentTimeMillis();
        launchPlanner.planRocketLaunches(rocketLaunches);
        long endPlanning = System.currentTimeMillis();
        System.out.println("Launch time: " + (endPlanning - startPlanning));
    }
}
