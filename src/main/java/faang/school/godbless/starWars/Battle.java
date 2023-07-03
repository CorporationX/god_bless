package faang.school.godbless.starWars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
  public Future<Robot> fight(Robot robot1, Robot robot2) {
    ExecutorService service = Executors.newSingleThreadExecutor();

    return service.submit(() -> {
      robot1.setDefensePower(robot1.getDefensePower() - robot2.getAttackPower());
      robot2.setDefensePower(robot2.getDefensePower() - robot1.getAttackPower());

      service.shutdown();
      return robot1.getDefensePower() > robot2.getDefensePower() ? robot1 : robot2;
    });
  }
}
