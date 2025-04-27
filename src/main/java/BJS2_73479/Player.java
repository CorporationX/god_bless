package BJS2_73479;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(1000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            log.info("Couldn't join the battle");
            throw new IllegalStateException("operation interrupted");
        }

    }
}
