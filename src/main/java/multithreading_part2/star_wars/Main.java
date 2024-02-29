package multithreading_part2.star_wars;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        Robot robot1 = new Robot("robot1", 10, 100);
        Robot robot2 = new Robot("robot2", 9, 109);
        Robot robot3 = new Robot("robot3", 20, 100);
        Robot robot4 = new Robot("robot4", 5, 60);
        Future<Robot> winnerFuture1 = battle.figth(robot1, robot2);
        Future<Robot> winnerFuture2 = battle.figth(robot3, robot4);
        try {
            Robot robotWinPair1 = winnerFuture1.get();
            Robot robotWinPair2 = winnerFuture2.get();
            System.out.println("Winner is " + robotWinPair1.getName());
            System.out.println("Winner is " + robotWinPair2.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
