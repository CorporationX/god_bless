package school.faang.SpaceX;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<RocketLaunch> rocketLaunches = new ArrayList<>();

    rocketLaunches.add(new RocketLaunch("firstLaunch", new Date(System.currentTimeMillis() + 2000)));
    rocketLaunches.add(new RocketLaunch("secondLaunch", new Date(System.currentTimeMillis() + 3000)));
    rocketLaunches.add(new RocketLaunch("thirdLaunch", new Date(System.currentTimeMillis() + 5000)));

    RocketLaunchManager.planRocketLaunches(rocketLaunches);
  }
}
