package school.faang.supercow;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Player {
    private final String name;

    public void doBattle(Boss boss) {
        try {
            log.debug("doBattle() is executing by Thread {}", Thread.currentThread().getName());
            boss.joinBattle(this);
            Thread.sleep(1000);
            boss.leaveBattle(this);
            log.debug("Player left the battle");
        } catch (InterruptedException e) {
            log.debug("Thread interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}
