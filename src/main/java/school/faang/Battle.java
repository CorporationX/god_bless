package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2, ExecutorService executor) {
        return executor.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Sleep interrupted in method \"fight\"");
                throw new RuntimeException(e);
            }
            log.info("Battle between {} and {} started.", robot1.getName(), robot2.getName());

            if (robot1.getAttackPower() - robot1.getDefencePower()
                    > robot2.getAttackPower() - robot2.getDefencePower()) {
                log.info("{} won the battle!", robot1.getName());
                return robot1;
            }
            log.info("{} won the battle!", robot2.getName());
            return robot2;
        });
    }
}
