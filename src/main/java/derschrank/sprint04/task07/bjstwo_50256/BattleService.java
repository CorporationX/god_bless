package derschrank.sprint04.task07.bjstwo_50256;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
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
        List<Robot> robots = new ArrayList<>(32);
        robots.addAll(getRobots("R2-D", 5, 7, 8));
        robots.addAll(getRobots("C-3PO-", 4, 8, 8));
        robots.addAll(getRobots("BB-8-", 6, 6, 9));
        robots.addAll(getRobots("BB-9-0", 7, 5, 7));
        return robots;
    }

    public static List<Robot> getRobots(String name, int attackPower, int defensePower, int count) {
        List<Robot> robots = new LinkedList<>();
        for (int i = 1; i <= count; i++) {
            robots.add(new Robot(name + i, attackPower, defensePower));
        }
        return robots;
    }
}
