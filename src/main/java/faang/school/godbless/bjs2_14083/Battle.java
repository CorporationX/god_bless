package faang.school.godbless.bjs2_14083;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Battle {

  private static final int CRITICAL_CHANCE = 4;
  private static final int NUMBER_OPPONENTS = 2;
  private static final double CRITICAL_DAMAGE = 1.5;
  private static final int POSSIBLE_VALUE = 10;
  private static final int REMAINDER = 0;
  private static final double MIN_HEALTH_VALUE = 0;

  ExecutorService executorService;
  Random random = new Random();

  public Battle(ExecutorService executorService) {
    this.executorService = executorService;
  }

  public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
    return executorService.submit(() -> getDamage(firstRobot, secondRobot));
  }

  private Robot getDamage(Robot firstRobot, Robot secondRobot) {
    while (firstRobot.getHealth() >= MIN_HEALTH_VALUE && secondRobot.getHealth() >= MIN_HEALTH_VALUE) {
      final int first_strike  = random.nextInt(NUMBER_OPPONENTS) % NUMBER_OPPONENTS;
      switch (first_strike) {
        case 0 -> firstRobot.changeHealth(getCriticalDamage(secondRobot.getAttackPower()));
        case 1 -> secondRobot.changeHealth(getCriticalDamage(firstRobot.getAttackPower()));
      }
    }
    return firstRobot.getHealth() <= MIN_HEALTH_VALUE ? secondRobot : firstRobot;
  }

  private double getCriticalDamage(int damage) {
    return random.nextInt(POSSIBLE_VALUE) % CRITICAL_CHANCE == REMAINDER ?
        damage * CRITICAL_DAMAGE : damage;
  }
}
