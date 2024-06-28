package faang.school.godbless.starWarsArena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);
    Random random = new Random();

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return executorService.submit(() -> attach(firstRobot, secondRobot));
    }

    private Robot attach(Robot firstRobot, Robot secondRobot) {
        while (true) {
            switch (random.nextInt(1)) {
                case 0:
                    if (firstRobot.getHelth() > 0) {
                        setRobotHealth(secondRobot, firstRobot);
                        if (secondRobot.getHelth() <= 0) {
                            return firstRobot;
                        }
                    } else {
                        return secondRobot;
                    }
                case 1:
                    if (secondRobot.getHelth() > 0) {
                        setRobotHealth(firstRobot, secondRobot);
                        if (firstRobot.getHelth() <= 0) {
                            return secondRobot;
                        }
                    } else {
                        return firstRobot;
                    }
            }
        }
    }

    private void setRobotHealth(Robot firstRobot, Robot secondRobot) {
        firstRobot.setHelth(firstRobot.getHelth() - (secondRobot.getAttackPower() - firstRobot.getDefensePower()));
        System.out.println(secondRobot.getName() + " атаковал " + firstRobot.getName()
                + " жизней " + firstRobot.getName() + " :" + firstRobot.getHelth());
    }
}