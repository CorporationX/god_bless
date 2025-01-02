package derschrank.sprint04.task07.bjstwo_50256;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class BattleService {
    public static List<Future<Fighting>> letsFightAllRobots(BattleInterface battle, List<Robot> robots) {
        int countOfRobots = robots.size();

        List<Future<Fighting>> results = new ArrayList<>();
        for (int i = 0; i < countOfRobots / 2; i++) {
            results.add(
                    battle.fight(
                            robots.get(i),
                            robots.get(countOfRobots - i - 1)
                    )
            );
        }
        return results;
    }

    public static Optional<Robot> printResultOfFightAndGetWinner(Future<Fighting> future) {
        Optional<Robot> winner = Optional.ofNullable(null);
        Optional<Fighting> result = getResultOfFighting(future);
        if (result.isEmpty()) {
            System.out.println("Fight was canceled!");
        } else {
            Fighting fighting = result.get();
            System.out.printf("Fight: %s vs %s: ", fighting.robot1(), fighting.robot2());

            winner = fighting.winner();
            if (winner.isEmpty()) {
                System.out.println("We don't have a winner!");
            } else {
                System.out.println("We have a winner!!! It is: " + winner.get());
            }
        }
        return winner;
    }

    private static Optional<Fighting> getResultOfFighting(Future<Fighting> future) {
        Fighting result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException | NullPointerException e) {
            log.error("Main was interrupted:\n" + e);
        }
        return Optional.ofNullable(result);
    }

    public static List<Robot> getRobots() {
        List<Robot> robots = new ArrayList<>();
        robots.add(new Robot("R2-D1", 5, 7));
        robots.add(new Robot("R2-D2", 5, 7));
        robots.add(new Robot("R2-D3", 5, 7));
        robots.add(new Robot("R2-D4", 5, 7));
        robots.add(new Robot("R2-D5", 5, 7));
        robots.add(new Robot("R2-D6", 5, 7));
        robots.add(new Robot("R2-D7", 5, 7));
        robots.add(new Robot("R2-D8", 5, 7));
        robots.add(new Robot("C-3PO-1", 4, 8));
        robots.add(new Robot("C-3PO-2", 4, 8));
        robots.add(new Robot("C-3PO-3", 4, 8));
        robots.add(new Robot("C-3PO-4", 4, 8));
        robots.add(new Robot("C-3PO-5", 4, 8));
        robots.add(new Robot("C-3PO-6", 4, 8));
        robots.add(new Robot("C-3PO-7", 4, 8));
        robots.add(new Robot("C-3PO-8", 4, 8));
        robots.add(new Robot("BB-8-1", 6, 6));
        robots.add(new Robot("BB-8-2", 6, 6));
        robots.add(new Robot("BB-8-3", 6, 6));
        robots.add(new Robot("BB-8-4", 6, 6));
        robots.add(new Robot("BB-8-5", 6, 6));
        robots.add(new Robot("BB-8-6", 6, 6));
        robots.add(new Robot("BB-8-7", 6, 6));
        robots.add(new Robot("BB-8-8", 6, 6));
        robots.add(new Robot("BB-8-9", 6, 6));
        robots.add(new Robot("BB-9-0", 7, 5));
        robots.add(new Robot("BB-9-1", 7, 5));
        robots.add(new Robot("BB-9-2", 7, 5));
        robots.add(new Robot("BB-9-3", 7, 5));
        robots.add(new Robot("BB-9-4", 7, 5));
        robots.add(new Robot("BB-9-5", 7, 5));
        robots.add(new Robot("BB-9-6", 7, 5));

        return robots;
    }
}
