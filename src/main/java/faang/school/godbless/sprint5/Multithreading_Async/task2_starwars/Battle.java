package faang.school.godbless.sprint5.Multithreading_Async.task2_starwars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Robot> submit = executor.submit(() -> {
            int totalPointsRobot1 = robot1.getAttackPower() + robot1.getDefensePower();
            int totalPointsRobot2 = robot2.getAttackPower() + robot2.getDefensePower();
            if (totalPointsRobot1 > totalPointsRobot2) {
                return robot1;
            } else if (totalPointsRobot2 > totalPointsRobot1) {
                return robot2;
            } else {
                throw new IllegalStateException("No winner");
            }
        });
        executor.shutdown();
        return submit;
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
