package school.faang.bjs2_82118;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);

        try {
            log.info("Player \"{}\" is fighting", name);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error("InterruptedException", e);
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
