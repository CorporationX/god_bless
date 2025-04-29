package supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Getter
@Slf4j
@AllArgsConstructor
public class Player {
    private String name;
    private static final int SLEEP_MILLIS = 5000;

    public void doBattle(Boss boss) {
        if (Objects.isNull(boss)) {
            log.error("Null argument!");
            return;
        }

        try {
            boss.joinBattle(this);
            Thread.sleep(SLEEP_MILLIS);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            log.error("Thread is interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
