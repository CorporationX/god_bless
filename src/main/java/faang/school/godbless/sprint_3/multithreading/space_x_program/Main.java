package faang.school.godbless.sprint_3.multithreading.space_x_program;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RocketLaunch rocketLaunch = new RocketLaunch();
        List<RocketLaunch> launchLIst = new ArrayList<>();
        launchLIst.add(new RocketLaunch("Rocket #1", LocalDateTime.now().plusSeconds(10)));
        launchLIst.add(new RocketLaunch("Rocket #2", LocalDateTime.now().plusSeconds(15)));
        launchLIst.add(new RocketLaunch("Rocket #3", LocalDateTime.now().plusSeconds(23)));
        long startTime = System.currentTimeMillis();
        rocketLaunch.planRocketLaunches(launchLIst);
        long endTime = System.currentTimeMillis();
        long result = (endTime - startTime) / 1000;
        System.out.printf("Метод проработал %d секунд", result);
    }
}
