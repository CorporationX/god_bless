package school.faang.bjs2_92999;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Battle {
    static final int FIGHT_DURATION = 5;
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    Future<Robot> fight(Robot robot1, Robot robot2) {
        return EXECUTOR.submit(() -> {
            log.info("Начинается битва между роботами {} и {}", robot1.getName(), robot2.getName());
            try {
                TimeUnit.SECONDS.sleep(FIGHT_DURATION);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if ((robot1.getAttackPower() - robot1.getDefensePower())
                    > (robot2.getAttackPower() - robot2.getDefensePower())) {
                return robot1;
            } else {
                return robot2;
            }
        });
    }
}
