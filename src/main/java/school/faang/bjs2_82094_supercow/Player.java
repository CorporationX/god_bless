package school.faang.bjs2_82094_supercow;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
@ToString
public class Player {
    private static final int MAX_BATTLE_DURATION_MS = 10000;
    private static final int MIN_BATTLE_DURATION_MS = 1000;

    private String name;


    public void doBattle(Boss boss) {
        log.info("Player {} wants to join the battle.", name);
        try {
            boss.joinBattle(this);
            log.info("Player {} joined the battle.", name);
            Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_BATTLE_DURATION_MS, MAX_BATTLE_DURATION_MS));
            log.info("Player {} wants to leave the battle.", name);
            boss.leaveBattle(this);
            log.info("Player {} left the battle.", name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
