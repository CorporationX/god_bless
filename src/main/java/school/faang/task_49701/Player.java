package school.faang.task_49701;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Player {
    private static final Integer BATTLE_TIME_IN_SECONDS = 2000;
    @Getter
    private final String name;

    public synchronized void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(BATTLE_TIME_IN_SECONDS);
            boss.leaveFromBattle(this);
        } catch (InterruptedException e) {
            log.error("Поток был прерван во время выполнения метода sleep()", e);
        }
    }
}
