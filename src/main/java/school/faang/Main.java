package school.faang;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        Future<Robot> winnerFuture1 = battle.fight(r2d2, c3po, executor);
        Future<Robot> winnerFuture2 = battle.fight(bb8, c3po, executor);
        try {
            winnerFuture1.get();
            winnerFuture2.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
