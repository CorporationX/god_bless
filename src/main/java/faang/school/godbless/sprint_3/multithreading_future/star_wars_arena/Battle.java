package faang.school.godbless.sprint_3.multithreading_future.star_wars_arena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Robot> winner = service.submit(() -> {
            System.out.printf("%s начинает сражение с роботом %s%n", firstRobot.getName(), secondRobot.getName());
            while (firstRobot.getDefensePower() > 0 && secondRobot.getDefensePower() > 0) {
                int random = new Random().nextInt(2);
                int currentDefence;
                switch (random) {
                    case 0:
                        System.out.printf("%s атакует %s%n", firstRobot.getName(), secondRobot.getName());
                        currentDefence = secondRobot.getDefensePower() - firstRobot.getAttackPower();
                        secondRobot.setDefensePower(currentDefence);
                        System.out.printf("У %s осталось %d защиты%n", secondRobot.getName(), secondRobot.getDefensePower());
                    case 1:
                        System.out.printf("%s атакует %s%n", secondRobot.getName(), firstRobot.getName());
                        currentDefence = firstRobot.getDefensePower() - secondRobot.getAttackPower();
                        firstRobot.setDefensePower(currentDefence);
                        System.out.printf("У %s осталось %d защиты%n", firstRobot.getName(), firstRobot.getDefensePower());
                }
            }
            return firstRobot.getDefensePower() <= 0 ? secondRobot : firstRobot;
        });
        service.shutdown();
        return winner;
    }
}