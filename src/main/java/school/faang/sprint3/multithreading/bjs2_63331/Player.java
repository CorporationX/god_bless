package school.faang.sprint3.multithreading.bjs2_63331;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private static final int BATTLE_TIME = 1500;
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(BATTLE_TIME);
        } catch (InterruptedException e) {
            log.warn("\nThread {} was interrupted", Thread.currentThread().getName());
        }
        boss.leaveBattle(this);
    }
}
