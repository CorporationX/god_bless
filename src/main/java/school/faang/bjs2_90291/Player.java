package school.faang.bjs2_90291;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private static final int BATTLE_DURATION = 2000;
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);

        try {
            log.info("{} начал сражение с боссом!", name);
            Thread.sleep(BATTLE_DURATION);
            log.info("{} закончил сражение с боссом!", name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("{} был прерван во время боя", name, e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
