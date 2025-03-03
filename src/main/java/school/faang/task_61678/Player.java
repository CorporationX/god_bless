package school.faang.task_61678;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Getter
@RequiredArgsConstructor
@Slf4j
public class Player {
    public static final int BATTLE_DURATION_MILLIS = 500;

    private final String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            log.info("Player: {}, Status: Battle Started", name);

            performBattle();
        } catch (Exception e) {
            log.error("Player: {}, failed to join battle due to an error", name, e);
        } finally {
            boss.leaveBattle(this);
        }
    }
    @SneakyThrows
    private static void performBattle() {
        Thread.sleep(BATTLE_DURATION_MILLIS);
    }
}
