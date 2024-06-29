package faang.school.godbless.starWarsArena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private Random random = new Random();

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return executorService.submit(() -> attach(firstRobot, secondRobot));
    }

    private Robot attach(Robot firstRobot, Robot secondRobot) {
        while (true) {
            switch (random.nextInt(1)) {
                case 0:
                    robotAttach(firstRobot, secondRobot);
                case 1:
                    robotAttach(secondRobot, firstRobot);
            }
        }
    }

    private Robot robotAttach(Robot firstRobot, Robot secondRobot) {
        if (firstRobot.getHelth() > 0) {
            firstRobot.setHelth(firstRobot.getHelth() - (secondRobot.getAttackPower() - firstRobot.getDefensePower()));
            System.out.println(secondRobot.getName() + " атаковал " + firstRobot.getName()
                    + " жизней " + firstRobot.getName() + " :" + firstRobot.getHelth());
            if (secondRobot.getHelth() <= 0) {
                return firstRobot;
            }
        }
        return secondRobot;
    }
}