package school.faang.supercowbjs49732;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter

public class Player {
    private static final Logger logger =
            LoggerFactory.getLogger(Player.class);
    private String name;
    private static final int BATTLE_DURATION = 2000;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            logger.info("{} start battle", name);
            Thread.sleep(BATTLE_DURATION);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("{} interrupted during combat", name);
        }
        boss.leaveBattle(this);
    }
}
