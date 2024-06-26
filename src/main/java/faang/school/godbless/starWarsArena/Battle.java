package faang.school.godbless.starWarsArena;

import java.util.Random;
import java.util.concurrent.*;

public class Battle {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Random random = new Random();

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return executorService.submit(() -> attach(firstRobot, secondRobot));
    }

    private Robot attach(Robot firstRobot, Robot secondRobot) {
        while (true) {
            switch (random.nextInt(1)) {
                case 0:
                    if (firstRobot.getHelth() > 0) {
                        secondRobot.setHelth(secondRobot.getHelth() - (firstRobot.getAttackPower() - secondRobot.getDefensePower()));
                        System.out.println(firstRobot.getName() + " атаковал " + secondRobot.getName()
                                + " жизней " + secondRobot.getName() + " :" + secondRobot.getHelth());
                        if (secondRobot.getHelth() <= 0) {
                            return firstRobot;
                        }
                    } else {
                        return secondRobot;
                    }
                case 1:
                    if (secondRobot.getHelth() > 0) {
                        firstRobot.setHelth(firstRobot.getHelth() - (secondRobot.getAttackPower() - firstRobot.getDefensePower()));
                        System.out.println(secondRobot.getName() + " атаковал " + firstRobot.getName()
                                + " жизней " + firstRobot.getName() + " :" + firstRobot.getHelth());
                        if (firstRobot.getHelth() <= 0) {
                            return secondRobot;
                        }
                    } else {
                        return firstRobot;
                    }
            }
        }
    }
}