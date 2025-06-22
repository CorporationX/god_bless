package school.faang.module1.bjs2_82103;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Player {

    private final String name;
    private static final int TIMEOUT = 3000;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("{} начал сражение с боссом...", name);
            Thread.sleep(TIMEOUT);
            log.info("{} завершил сражение с боссом", name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("{} был прерван во время боя", name, e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}