package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter
public class Player {

    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);
    private static final int TIME_OF_BATTLE = 5000;

    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(TIME_OF_BATTLE);
        } catch (InterruptedException e) {
            LOGGER.error("Поток прерван во время сна");
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }
}
