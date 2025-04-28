package school.faang.bjs2_73485;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Player {

    private final String name;
    private static final int THREAD_WAIT = 10000;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(THREAD_WAIT);
        } catch (InterruptedException e) {
            log.info("Thread {} has been interrupted!", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
