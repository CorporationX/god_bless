package school.faang.Mnogopotochka.Synhronaized.BJS2_36782;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@AllArgsConstructor
public class Player extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    private String playerName;
    private Boss boss;

    @Override
    public void run() {
        boss.joinBattle(this);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("{} был прерван во время сражения.", playerName);
        } finally {
            boss.leaveBattle(this);
        }
    }
}