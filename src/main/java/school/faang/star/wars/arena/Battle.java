package school.faang.star.wars.arena;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2, ExecutorService executor) {

        Future<Robot> winner = executor.submit(() -> {
            log.info("Битва: {} vs {}", robot1.toString(), robot2.toString());
            int totalPower1 = robot1.getAttackPower() + robot1.getDefensePower();
            int totalPower2 = robot2.getAttackPower() + robot2.getDefensePower();

            int result1 = totalPower1 - totalPower2;
            int result2 = totalPower2 - totalPower1;

            boolean winnerByLuck = Math.random() * 100 < 50;
            boolean winnerByPower = Math.max(result1, result2) == result1;

            if (result1 == result2) {
                return winnerByLuck ? robot1 : robot2;
            } else {
                return winnerByPower ? robot1 : robot2;
            }
        });

        return winner;
    }
}
