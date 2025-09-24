package school.faang.bjs2_92641;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StarWarsArena {
    private final static int THREAD_COUNT = 2;

    public static void main(String[] args) {
        Battle battle = new Battle(THREAD_COUNT);

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 10, 6);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);
        Future<Robot> winnerFuture2 = battle.fight(bb8, c3po);

        try {
            Robot winner = winnerFuture.get();
            Robot winner2 = winnerFuture2.get();
            System.out.println("Winner: " + winner.getName());
            System.out.println("Winner: " + winner2.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
