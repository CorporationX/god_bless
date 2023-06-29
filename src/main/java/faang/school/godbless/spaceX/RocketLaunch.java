package faang.school.godbless.spaceX;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketLaunch {
  private String name;
  private LocalDateTime launchTime;

  public RocketLaunch(String name, LocalDateTime launchTime) {
    this.name = name;
    this.launchTime = launchTime;
  }

  public void launch() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Rocket " + name + " has launched");
  }


  public static void planRocketLaunches(List<RocketLaunch> list) {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    for (RocketLaunch rocketLaunch : list) {
      LocalDateTime now = LocalDateTime.now();
      long duration = Duration.between(now, rocketLaunch.launchTime).toMillis();

      try {
        Thread.sleep(duration);
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      }
      executor.submit(rocketLaunch::launch);
    }

    executor.shutdown();

    try {
      executor.awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
