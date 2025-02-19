package school.faang.supercow.BJS2_61566;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record Player(String name) {
    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);

            LOGGER.info("{} сражается с боссом", name);

            Thread.sleep(4000);
        } catch (InterruptedException e) {
            LOGGER.error("{} был прерван во время сражения.", name);

            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }finally {
            boss.leaveBattle(this);
        }
    }
}
