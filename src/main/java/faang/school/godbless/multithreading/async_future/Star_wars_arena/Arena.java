package faang.school.godbless.multithreading.async_future.Star_wars_arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Arena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        // Создание роботов
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot r3d3 = new Robot("R3-D3", 4, 9);
        Robot c4po = new Robot("C-4PO", 7, 6);
        Robot r4d4 = new Robot("R4-D4", 1, 8);
        Robot c5po = new Robot("C-5PO", 4, 8);

        // Запуск битвы
        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);
        Future<Robot> secondBattleWinner = battle.fight(r3d3, c4po);
        Future<Robot> thirdBattleWinner = battle.fight(r4d4, c5po);

        // Обработка результата
        try {
            Robot winner = winnerFuture.get();
            Robot winner2 = secondBattleWinner.get();
            Robot winner3 = thirdBattleWinner.get();
            System.out.println("First fight winner: " + winner.getName());
            System.out.println("Second fight winner: " + winner2.getName());
            System.out.println("Third fight winner: " + winner3.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        battle.shutdown();
    }

}
