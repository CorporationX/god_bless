package school.faang.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;
    private static final Logger logger = LoggerFactory.getLogger(Player.class);

    public synchronized void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            logger.info("{} fighting with boss...", this.getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.info("The battle was interrupted");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }

    }

}
