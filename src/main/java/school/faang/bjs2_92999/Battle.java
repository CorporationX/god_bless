package school.faang.bjs2_92999;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class Battle {
    private static final int FIGHT_DURATION = 5;
    private static final double RANDOM_FACTOR = 0.5;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            log.info("Начинается битва между роботами {} и {}", robot1.getName(), robot2.getName());
            try {
                TimeUnit.SECONDS.sleep(FIGHT_DURATION);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int robot1Power = robot1.getAttackPower() - robot1.getDefensePower();
            int robot2Power = robot2.getAttackPower() - robot2.getDefensePower();
            if (robot1Power > robot2Power) {
                return robot1;
            } else if (robot1Power < robot2Power) {
                return robot2;
            } else {
                return Math.random() > RANDOM_FACTOR ? robot1 : robot2;
            }
        });
    }
}
