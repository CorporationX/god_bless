package school.faang.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RocketLaunch {
  private String name;
  private Date launchTime;

  public void launch() {
    long startLaunchTime = System.currentTimeMillis();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
    System.out.printf("%s -> %s ракета запущена за %d\n",launchTime, name, System.currentTimeMillis() - startLaunchTime);
  }
}
