package school.faang.supercow;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();
    private static final Logger logger = LoggerFactory.getLogger(Boss.class);

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    logger.info("{} waiting for a free spot...", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            logger.info("{} joined the battle", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            logger.info("{} left the battle", player.getName());
            lock.notify();
        }
    }

}
