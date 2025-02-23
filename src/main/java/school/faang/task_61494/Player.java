package school.faang.task_61494;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Player {
    private static final Logger LOG = LoggerFactory.getLogger(Player.class);
    private static final int MIN_TIME_FIGHT = 1000;
    private static final int MAX_TIME_FIGHT = 5000;
    private final Random random = new Random();
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            LOG.info("Player {} is fighting a boss", getName());
            Thread.sleep(random.nextInt(MIN_TIME_FIGHT, MAX_TIME_FIGHT));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("This thread has been interrupted", e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
