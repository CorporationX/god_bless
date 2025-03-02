package school.faang.supercow;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private static final Logger logger = LoggerFactory.getLogger(Boss.class);

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                logger.info("{} waiting for a free spot...", player.getName());
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        logger.info("{} joined the battle", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        logger.info("{} left the battle", player.getName());
        this.notify();
    }
}
