package faang.school.godbless.starwars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
        Battle battle = new Battle();
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        BiConsumer<Robot, Robot> battleLogic = (robot1, robot2) -> {
            robot1.attack(robot2);
            if (robot2.isAlive()) {
                robot2.attack(robot1);
            }
        };
        Future<Robot> winnerFuture = battle.fight(r2d2, c3po, battleLogic);

        Robot winner = getFromFuture(winnerFuture);
        battle.shutdownAndAwaitExecution(5L);
        System.out.println("And the winner is... " + winner.getName());
    }

    private static <T> T getFromFuture(Future<T> future) {
        try {
            return future.get(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
