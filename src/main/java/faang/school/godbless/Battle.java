package faang.school.godbless;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Battle {
    private ExecutorService executor;

    public Battle() {
        executor = Executors.newFixedThreadPool(1);
    }

    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        battle.shutdown();
    }

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            int rounds = 3;
            int robot1TotalPower = robot1.getAttackPower() - robot2.getDefensePower();
            int robot2TotalPower = robot2.getAttackPower() - robot1.getDefensePower();

            int robot1Wins = 0;
            int robot2Wins = 0;

            for (int i = 0; i < rounds; i++) {
                if (robot1TotalPower > 0) {
                    robot1Wins++;
                }
                if (robot2TotalPower > 0) {
                    robot2Wins++;
                }
            }

            if (robot1Wins > robot2Wins) {
                return robot1;
            } else {
                return robot2;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }

}
