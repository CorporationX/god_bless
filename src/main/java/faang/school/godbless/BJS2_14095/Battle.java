package faang.school.godbless.BJS2_14095;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class Battle {
    private final ExecutorService service = Executors.newFixedThreadPool(2);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        AtomicInteger diff = new AtomicInteger();
        return service.submit(() -> {
            diff.set((robot1.getAttackPower() - robot2.getDefensePower()) - (robot2.getAttackPower() - robot1.getDefensePower()));
            if (diff.get() > 0) {
                return robot1;
            } else {
                return robot2;
            }
        });
    }

    public void shutdownPool() {
        this.service.shutdown();
    }

    public static void main(String[] args) {
        Battle battle = new Battle();
        Robot r2d2 = new Robot("r2d2", 5, 3);
        Robot c3po = new Robot("c3po", 8, 4);
        Robot bd1 = new Robot("BD-1", 6, 3);
        Robot bb8 = new Robot("BB-8", 5, 4);
        Robot l337 = new Robot("L3-37", 8, 5);
        Robot k2s0 = new Robot("K-2S0", 9, 6);
        Future<Robot> firstWinnerFuture = battle.fight(r2d2, c3po);
        Future<Robot> secondWinnerFuture = battle.fight(bd1, l337);
        Future<Robot> thirdWinnerFuture = battle.fight(k2s0, bb8);
        try {

            Robot firstWinner = firstWinnerFuture.get(10, TimeUnit.SECONDS);
            Robot secondWinner = secondWinnerFuture.get(10, TimeUnit.SECONDS);
            Robot thirdWinner = thirdWinnerFuture.get(10, TimeUnit.SECONDS);
            battle.shutdownPool();
            System.out.println("first winner is " + firstWinner.getName() + " second winner is " + secondWinner.getName() + " third winner is " + thirdWinner.getName());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.getStackTrace();
        }
    }
}
