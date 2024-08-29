package faang.school.godbless.starWars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7, 20);
        Robot c3po = new Robot("C-3PO", 4, 8, 20);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get(1, TimeUnit.MINUTES);
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("The battle was interrupted.");
        } catch (TimeoutException e) {
            System.out.println("The battle was timed out.");
        }

        battle.getExecutorService().shutdown();
        try {
            if (!battle.getExecutorService().awaitTermination(1, TimeUnit.MINUTES)) {
                battle.getExecutorService().shutdownNow();
            }
        } catch (InterruptedException e) {
            battle.getExecutorService().shutdownNow();
        }
    }
}
