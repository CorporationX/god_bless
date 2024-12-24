package school.faang.bjs_49692;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
public class Player {
    private static final int BATTLE_DURATION = 100;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        log.info("Player {} has battle started.", name);

        try {
            Thread.sleep(BATTLE_DURATION);
        } catch (InterruptedException e) {
            log.error("Player {} has battle interrupted.", name);
        }

        boss.leaveBattle(this);
        log.info("Player {} has battle finished.", name);
    }

}
