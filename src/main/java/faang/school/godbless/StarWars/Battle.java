package faang.school.godbless.StarWars;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final int COUNT_THREAD = 4;
    private static final Random RANDOM = new Random();
    @Getter
    private final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

    public Future<Robot> fight(Robot robotOne, Robot robotTwo) {
        return executorService.submit(() -> fighting(robotOne, robotTwo));
    }

    private Robot fighting(Robot robot1, Robot robot2) {
        while (true) {
            switch (RANDOM.nextInt(2)) {
                case 0:
                    if (robot1.getHp() > 0) {
                        attack(robot1, robot2);
                        if (robot2.getHp() <= 0) {
                            return robot1;
                        }
                    }
                case 1:
                    if (robot2.getHp() > 0) {
                        attack(robot2, robot1);
                        if (robot1.getHp() <= 0) {
                            return robot2;
                        }
                    }
            }
        }
    }

    private void attack(Robot one, Robot two) {
        int damage = two.getHp() - (one.getAttackPower() - two.getDefensePower());
        System.out.println(one.getName() + " наносит " + damage + " урона");
        two.setHp(damage);
    }

}
