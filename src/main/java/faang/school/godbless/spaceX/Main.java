package faang.school.godbless.spaceX;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<RocketLaunch> rocketLaunches = new ArrayList<>();

    rocketLaunches.add(new RocketLaunch("Rocket 1", LocalDateTime.now().plusSeconds(2)));
    rocketLaunches.add(new RocketLaunch("Rocket 2", LocalDateTime.now().plusSeconds(4)));
    rocketLaunches.add(new RocketLaunch("Rocket 3", LocalDateTime.now().plusSeconds(6)));

    long startTime = System.currentTimeMillis();

    RocketLaunch.planRocketLaunches(rocketLaunches);

    long endTime = System.currentTimeMillis();
    long totalTime = (endTime - startTime) / 1000;

    System.out.printf("Execution time was: " + totalTime);
  }
}
