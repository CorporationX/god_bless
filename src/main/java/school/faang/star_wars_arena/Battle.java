package school.faang.star_wars_arena;

import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@AllArgsConstructor
public class Battle {
    private ExecutorService executor;

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        Objects.requireNonNull(robot1, "First robot must not be null");
        Objects.requireNonNull(robot2, "Second robot must not be null");
        return executor.submit(() -> calculateDifference(robot1, robot2));
    }

    public Robot calculateDifference(Robot robot1, Robot robot2) {
        int robot1Damage = robot1.getAttackPower() - robot2.getDefensePower();
        int robot2Damage = robot2.getAttackPower() - robot1.getDefensePower();

        return robot1Damage >= robot2Damage ? robot1 : robot2;
    }
}
