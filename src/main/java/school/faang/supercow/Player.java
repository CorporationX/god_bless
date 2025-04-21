package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Player {
    private static final int MIN_SLEEP_MS = 1000;
    private static final int MAX_SLEEP_MS = 10000;

    private final String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            mechanicsBattle();
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            log.warn("Бой игрока {} был прерван.", this.name);
            Thread.currentThread().interrupt();
        }
    }

    private void mechanicsBattle() throws InterruptedException {
        int battleTime = ThreadLocalRandom.current().nextInt(MIN_SLEEP_MS, MAX_SLEEP_MS);
        log.info("Игрок {} сражается с боссом! Длительность боя: {}", this.name, battleTime);
        Thread.sleep(battleTime);
    }
}
