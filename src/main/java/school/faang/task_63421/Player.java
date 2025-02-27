package school.faang.task_63421;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class Player {
    private static final int DELAY = 5000;
    private final String name;

    public synchronized void doBattle(Boss boss) {
        try {
            log.info("{} пытается присоединиться к бою", name);
            boss.joinBattle(this);
            log.info("{} начал сражение", name);

            Thread.sleep(DELAY);

            log.info("{} завершил сражение", name);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("{} был прерван во время сражения", name, e);
        }
    }
}
