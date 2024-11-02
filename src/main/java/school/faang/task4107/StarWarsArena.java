package school.faang.task4107;

import java.util.Random;
import java.util.concurrent.*;

class Robot {
    private final String name;
    private final int attackPower;
    private final int defensePower;

    public Robot(String name, int attackPower, int defensePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public int getTotalPower() {
        return attackPower + defensePower;
    }
}

class Battle {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            int powerDifference1 = robot1.getTotalPower();
            int powerDifference2 = robot2.getTotalPower();

            if (powerDifference1 > powerDifference2) {
                return robot1;
            } else if (powerDifference2 > powerDifference1) {
                return robot2;
            } else {
                return new Random().nextBoolean() ? robot1 : robot2;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}

public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        battle.shutdown();
    }
}

