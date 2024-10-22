package school.faang.star_wars_arena_BJS2_38298;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
public class Battle {
    private final int THREADS = 20;
    private final ExecutorService service = Executors.newFixedThreadPool(THREADS);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        int totalPower1 = robot1.getAttackPower() + robot1.getDefencePower();
        int totalPower2 = robot2.getAttackPower() + robot2.getDefencePower();

        return service.submit(() -> totalPower1 >= totalPower2 ? robot1 : robot2);
    }
}
