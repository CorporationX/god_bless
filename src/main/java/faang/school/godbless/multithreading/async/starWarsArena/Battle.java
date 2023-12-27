package faang.school.godbless.multithreading.async.starWarsArena;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Battle battle = new Battle();

// Создание роботов
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Robot d2oz = new Robot("D-2OZ", 6, 5);
        Robot p3z7 = new Robot("P3-Z7", 4, 8);

// Запуск битвы
        Future<Robot> winnerFuture1 = battle.fight(r2d2, c3po);
        Future<Robot> winnerFuture2 = battle.fight(d2oz, p3z7);

        while (!winnerFuture1.isDone() || !winnerFuture2.isDone()) {
            System.out.println("Do something..");
        }

// Обработка результата
        try {
            Robot winner1 = winnerFuture1.get();
            Robot winner2 = winnerFuture2.get();
            System.out.println("Победитель первой битвы: " + winner1.getName());
            System.out.println("Победитель второй битвы: " + winner2.getName());
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }
    }


    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Random random = new Random();

        return executor.submit(() -> {
            try {
                Thread.sleep(5_000L);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            int randomValue = 1 + random.nextInt(2);
            executor.shutdown();
            return randomValue == 1 ? firstRobot : secondRobot;
        });
    }
}
