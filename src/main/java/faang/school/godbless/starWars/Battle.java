package faang.school.godbless.starWars;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Future;

public class Battle {
  ExecutorService service;

  public Battle(ExecutorService service) {
    this.service = service;
  }

  public Future<Robot> fight(Robot robot1, Robot robot2) {
    return service.submit(() -> {
      robot1.setDefensePower(robot1.getDefensePower() - robot2.getAttackPower());
      robot2.setDefensePower(robot2.getDefensePower() - robot1.getAttackPower());

      return robot1.getDefensePower() > robot2.getDefensePower() ? robot1 : robot2;
    });
  }
}
