package school.faang.bjs2_73733;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Slf4j
public class Player {
    private static final long SLEEP_TIME = 2_000;
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted. {}.", e.getMessage());
            Thread.currentThread().interrupt();
        }
        boss.leaveBattle(this);
    }
}
