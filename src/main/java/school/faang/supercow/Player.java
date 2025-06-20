package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@AllArgsConstructor
public class Player {
    private static final int BATTLE_TIME_MS = 1000;
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("Игрок {} ведет сражение", name);
            Thread.sleep(BATTLE_TIME_MS);
        } catch (InterruptedException e) {
            log.error("Игрок {} был прерван во время сражения", name);
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
            log.info("Игрок {} покинул сражение", name);
        }
    }
}
