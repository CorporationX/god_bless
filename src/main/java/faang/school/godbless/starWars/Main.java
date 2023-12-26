package faang.school.godbless.starWars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot("robot", 5, 10);
        Robot robot1 = new Robot("robot1", 8, 7);
        Battle battle = new Battle();

        Future<Robot> winnerFuture = battle.fight(robot, robot1);
// что-то после запуска я так и не понял, в чем суть этого всего.
        try {
            Robot winner = winnerFuture.get();
            System.out.println(winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
