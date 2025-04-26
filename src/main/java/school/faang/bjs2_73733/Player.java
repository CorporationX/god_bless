package school.faang.bjs2_73733;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Slf4j
public class Player {
    private final String name;
    private final long sleepTime = 2_000;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted. {}.", e.getMessage());
        }
        boss.leaveBattle(this);
    }
}
