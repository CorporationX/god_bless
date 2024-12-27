package school.faang.task_49701;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Player {
    private static final Integer BATTLE_TIME_MILLIS = 2000;
    @Getter
    private final String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(BATTLE_TIME_MILLIS);
            boss.leaveFromBattle(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток был прерван во время выполнения метода sleep()", e);
        }
    }
}
