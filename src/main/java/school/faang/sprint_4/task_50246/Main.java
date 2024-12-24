package school.faang.sprint_4.task_50246;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 8, 6);

        Future<Robot> firstWinnerFuture = battle.fight(r2d2, c3po);
        Future<Robot> secondWinnerFuture = battle.fight(r2d2, bb8);

        try {
            Robot firstWinner = firstWinnerFuture.get();
            System.out.println("First fight winner: " + firstWinner.name());

            Robot secondWinner = secondWinnerFuture.get();
            System.out.println("Second fight winner: " + secondWinner.name());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        battle.shutdown();
    }
}
