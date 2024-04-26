package star_wars_arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return SERVICE.submit(() -> {
            while (robot1.getHealth() > 0 && robot2.getHealth() > 0) {
                robot2.setHealth(robot2.getHealth() - (robot1.getAttackPower() - robot2.getDefencePower()));
                robot1.setHealth(robot1.getHealth() - (robot2.getAttackPower() - robot1.getDefencePower()));
            }
            SERVICE.shutdown();
            return robot1.getHealth() > 0 ? robot1 : robot2;
        });
    }

    public static void main(String[] args) {
        Battle battle = new Battle();
        Robot r2d2 = new Robot("R2D2", 1000, 50, 15);
        Robot c3po = new Robot("C-3PO", 1500, 70, 20);
        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
