package faang.school.godbless.StarWarsArena;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public static void main(String[] args) {
        Battle battle = new Battle();

// Создание роботов
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

// Запуск битвы
        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

// Обработка результата
        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        return executor.submit(() -> {
            if (new Random().nextBoolean()) {
                robot1.setDefensePower(robot1.getDefensePower() - robot2.getAttackPower());
                executor.shutdown();
                return robot1.getDefensePower() > 0 ? robot1 : robot2;
            } else {
                robot2.setDefensePower(robot2.getDefensePower() - robot1.getAttackPower());
                executor.shutdown();
                return robot2.getDefensePower() > 0 ? robot2 : robot1;
            }
        });
    }
}