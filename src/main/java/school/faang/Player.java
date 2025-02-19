package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@AllArgsConstructor
public class Player {
    private static final Logger logger = LoggerFactory.getLogger(Player.class);

    private final String name;
    private static final int BATTLE_DURATION = 2000;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            logger.info("{} is fighting the boss", name);
            Thread.sleep(BATTLE_DURATION);
        } catch (InterruptedException e) {
            logger.error("{} was interrupted while fighting.", name);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
    }
}
