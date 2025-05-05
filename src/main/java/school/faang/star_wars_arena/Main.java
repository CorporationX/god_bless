package school.faang.star_wars_arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Battle battle = new Battle(executorService);

        // Создание роботов
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        // Запуск битвы
        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);
        Future<Robot> fight1 = battle.fight(r2d2, bb8);
        Future<Robot> fight = battle.fight(c3po, bb8);

        // Обработка результата битвы
        try {
            Robot winner1 = winnerFuture.get();
            Robot winner2 = fight1.get();
            Robot winner3 = fight.get();
            System.out.printf("First battle winner: %s%nSecond battle winner: %s%nThird battle winner: %s%n",
                    winner1.getName(), winner2.getName(), winner3.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
