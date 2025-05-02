package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class Player implements Runnable {
    public static final int MILLIS_IN_SECOND = 2000;
    private final String name;
    private final Boss boss;

    public void doBattle() {
        boss.joinBattle(this);

        try {
            log.info("{} is battling the boss...", name);
            Thread.sleep((long) (1000 + Math.random() * MILLIS_IN_SECOND));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("{} was interrupted during the battle.", name);
        } finally {
            boss.leaveBattle(this);
        }
    }

    @Override
    public void run() {
        doBattle();
    }
}