package school.faang.bjs2_90433;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {

    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("{} starting the boss battle!", this.getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.warn("{} has been interrupted", Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
        log.info("{} leave the instance", this.getName());
    }

}
