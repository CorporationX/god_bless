package school.faang.bjs2_92999;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Battle {
    ExecutorService executor = Executors.newCachedThreadPool();

    Future<Robot> fight(Robot robot1, Robot robot2) {
        log.info("Начинается битва между роботами {} и {}", robot1.getName(), robot2.getName());
        return executor.submit(() -> {
            if ((robot1.getAttackPower() - robot1.getDefensePower())
                    > (robot2.getAttackPower() - robot2.getDefensePower())) {
                return robot1;
            } else {
                return robot2;
            }
        });
    }
}
