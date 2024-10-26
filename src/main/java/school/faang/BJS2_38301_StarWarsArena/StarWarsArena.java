package school.faang.BJS2_38301_StarWarsArena;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot[] robots = {
                new Robot("R2-D2", 5, 7),
                new Robot("C-3PO", 4, 8),
                new Robot("BB-8", 6, 6)
        };

        startBattles(battle, robots);
    }

    private static void startBattles(Battle battle, Robot[] robots) {
        Map<String, CompletableFuture<Robot>> winnerByBattle = new HashMap<>();

        for (int firstRobotIndex = 0; firstRobotIndex < robots.length - 1; firstRobotIndex++) {
            for (int secondRobotIndex = firstRobotIndex + 1; secondRobotIndex < robots.length; secondRobotIndex++) {
                Robot first = robots[firstRobotIndex];
                Robot second = robots[secondRobotIndex];
                winnerByBattle.put(String.format("%s - %s", first.getName(), second.getName()), battle.fight(first, second));
            }
        }

        CompletableFuture.allOf(winnerByBattle.values().toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    winnerByBattle.forEach((pair, winner) ->
                            log.info("The winner of fight battle ({}) is {}", pair, winner.join().getName())
                    );
                    battle.shutdownExecutor();
                }).join();
    }
}
