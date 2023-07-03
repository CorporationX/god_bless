package faang.school.godbless.StarWarsArena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Arena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        // Robots creation
        Robot robot1 = new Robot("robot1", 5, 7);
        Robot robot2 = new Robot("robot2", 3, 9);
        Robot robot3 = new Robot("robot3", 2, 7);
        Robot robot4 = new Robot("robot4", 1, 5);
        Robot robot5 = new Robot("robot5", 2, 4);
        Robot robot6 = new Robot("robot6", 3, 3);

        // Execute battle
        Future<Robot> winnerFuture1 = battle.fight(robot1, robot2);
        Future<Robot> winnerFuture2 = battle.fight(robot3, robot4);
        Future<Robot> winnerFuture3 = battle.fight(robot5, robot6);

        // Result processing
        try {
            Robot winner1 = winnerFuture1.get();
            System.out.println("Winner: " + winner1.getName());
            Robot winner2 = winnerFuture2.get();
            System.out.println("Winner: " + winner2.getName());
            Robot winner3 = winnerFuture3.get();
            System.out.println("Winner: " + winner3.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
