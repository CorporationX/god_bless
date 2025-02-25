package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
public class Battle {
    private static final int BATTLE_DURATION_MS = 2000;

    public Future<Robot> fight(Robot robot1, Robot robot2, ExecutorService executor) {
        return executor.submit(() -> {
            try {
                Thread.sleep(BATTLE_DURATION_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Sleep interrupted in method \"fight\"");
                throw new RuntimeException(e);
            }
            log.info("Battle between {} and {} started.", robot1.name(), robot2.name());

            if (robot1.attackPower() - robot1.defencePower()
                    > robot2.attackPower() - robot2.defencePower()) {
                log.info("{} won the battle!", robot1.name());
                return robot1;
            }
            log.info("{} won the battle!", robot2.name());
            return robot2;
        });
    }
}
