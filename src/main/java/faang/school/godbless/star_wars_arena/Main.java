package faang.school.godbless.star_wars_arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot robot1 = new Robot("robot1", 12, 44);
        Robot robot2 = new Robot("robot2", 3, 33);

        Future<Robot> winnerFuture = battle.fight(robot1, robot2);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Winner: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        battle.shutdownExecutorService();
    }
}
