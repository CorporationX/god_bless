package BJS2_63369;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("Player {} is battling", name);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Interrupted while battling", e);
        } finally {
            log.info("Player {} finished the battle", name);
            boss.leaveBattle(this);
        }
    }
}
