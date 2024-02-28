package faang.school.godbless.multithreading_async.star_wars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Robot> winnerFuture = executorService.submit(() -> Robot.battleRobots(firstRobot, secondRobot));
        executorService.shutdown();
        return winnerFuture;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Robot robot1 = new Robot("Robot1", 20, 10);
        Robot robot2 = new Robot("Robot2", 15, 12);

        Battle battle = new Battle();
        Future<Robot> winnerFuture = battle.fight(robot1, robot2);

        Robot winner = winnerFuture.get();
        System.out.println("Winner: " + winner.getName());
    }
}
