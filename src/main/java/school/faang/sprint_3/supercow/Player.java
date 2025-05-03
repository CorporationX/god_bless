package school.faang.sprint_3.supercow;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        log.info("Player {} is in battle", name);
        Thread.sleep(10000);
        log.info("Player {} finished the battle", name);
        boss.leaveBattle(this);
    }
}
