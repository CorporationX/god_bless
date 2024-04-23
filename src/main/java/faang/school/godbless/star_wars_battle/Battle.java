package faang.school.godbless.star_wars_battle;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Random random = new Random();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        final Robot finalRobot1 = robot1;
        final Robot finalRobot2 = robot2;
        return executorService.submit(() -> {
            Robot currentRobot1 = finalRobot1;
            Robot currentRobot2 = finalRobot2;
            while (currentRobot1.getHealth() > 0 && currentRobot2.getHealth() > 0) {
                Robot attacker = random.nextBoolean() ? currentRobot1 : currentRobot2;
                Robot defender = (attacker == currentRobot1) ? currentRobot2 : currentRobot1;
                int damage = attacker.getAttackPower() - defender.getDefensePower();
                if (damage > 0) {
                    int newHealth = defender.getHealth() - damage;
                    defender.setHealth(newHealth > 0 ? newHealth : 0);
                    System.out.println(attacker.getName() + " атакует "
                            + defender.getName() + " и наносит " + damage + " урона.");
                    System.out.println("Здоровье " + attacker.getName() + ": "
                            + attacker.getHealth() + " | здоровье " + defender.getName() + ": " + defender.getHealth());
                } else {
                    System.out.println(attacker.getName() + " атакует " + defender.getName() + ", но урона недостаточно");
                }
                Robot temp = currentRobot1;
                currentRobot1 = currentRobot2;
                currentRobot2 = temp;
            }
            return finalRobot1.getHealth() > 0 ? finalRobot1 : finalRobot2;
        });
    }

    public void shutdown(){
        executorService.shutdown();
    }
}
