package school.faang.sprint3.multithreading.bjs2_63331;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Player {
    private static final int BATTLE_TIME = 500;
    private String name;


    public void doBattle(Boss boss)  {
        boss.joinBattle(this);
        System.out.printf("\n%s is battling with the boss", name);
        try {
            Thread.sleep(BATTLE_TIME);
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
        }
        boss.leaveBattle(this);
    }
}
