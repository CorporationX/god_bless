package school.faang.module1.bjs2_82103;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Player {

    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("{} начал сражение с боссом...", name);
            Thread.sleep(3000);
            log.info("{} завершил сражение с боссом", name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("{} был прерван во время боя", name, e);
        }
        boss.leaveBattle(this);
    }
}