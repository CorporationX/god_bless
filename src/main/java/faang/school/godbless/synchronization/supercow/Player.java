package faang.school.godbless.synchronization.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        if (boss == null) {
            return;
        }

        log.info("Player " + name + " tries to join the boss (" + boss.getName() + ") battle.");
        boss.joinBattle(this);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error("Battle with " + boss.getName() + " was interrupted");
        } finally {
            endBattle(boss);
        }
    }

    private void endBattle(Boss boss) {
        log.info("Player " + name + " tries to leave the boss (" + boss.getName() + ") battle.");
        boss.leaveBattle(this);
    }
}
