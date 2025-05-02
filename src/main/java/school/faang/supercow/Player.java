package school.faang.supercow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {
    private String name = "Player";
    private static int playersCount = 0;
    private final long battleTime = 5L;

    public Player() {
        playersCount++;
        this.name = getName() + playersCount;
    }

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info(this.name + " join to the battle!");
            Thread.sleep(battleTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
        log.info(this.name + " leave the battle!");
    }
}
