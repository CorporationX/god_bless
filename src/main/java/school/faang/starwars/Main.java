package school.faang.starwars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);
        Robot bb7 = new Robot("BB-7", 5, 5);

        try {
            Future<Robot> firstWinnerFuture = battle.fight(r2d2, c3po);
            System.out.println("Победитель первой битвы: " + firstWinnerFuture.get().getName());
            Future<Robot> secondWinnerFuture = battle.fight(bb8, bb7);
            System.out.println("Победитель второй битвы: " + secondWinnerFuture.get().getName());

            Future<Robot> finalWinnerFuture = battle.fight(firstWinnerFuture.get(), secondWinnerFuture.get());

            Robot winner = finalWinnerFuture.get();
            System.out.println("Победитель финальной битвы: " + winner.getName());

            battle.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}