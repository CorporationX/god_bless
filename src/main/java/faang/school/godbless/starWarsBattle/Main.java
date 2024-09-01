package faang.school.godbless.starWarsBattle;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 8, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        Robot winner = winnerFuture.get(10_000L, TimeUnit.SECONDS);
        System.out.println("Winner is " + winner);
    }
}
