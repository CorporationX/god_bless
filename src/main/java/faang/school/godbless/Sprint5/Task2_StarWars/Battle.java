package faang.school.godbless.Sprint5.Task2_StarWars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Robot> robotFuture = executor.submit(() -> {
            int robot1Power = robot1.getAttackPower() - robot2.getDefensePower();
            int robot2Power = robot2.getAttackPower() - robot1.getDefensePower();

            if (robot1Power > robot2Power) {
                return robot1;
            } else if (robot1Power < robot2Power) {
                return robot2;
            } else {
                throw new IllegalStateException("Nobody wins!");
            }
        });
        executor.shutdown();
        return robotFuture;
    }

    public static void main(String[] args) {
        Battle battle = new Battle();

// Создание роботов
        Robot r2d2 = new Robot("R2-D2", 6, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

// Запуск битвы
        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

// Обработка результата
        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
