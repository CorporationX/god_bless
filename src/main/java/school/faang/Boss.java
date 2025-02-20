package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Boss {
    private static final Logger logger = LoggerFactory.getLogger(Boss.class);
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                logger.info("Player {} is waiting for a free slot to fight the boss.", player.getName());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    logger.error("Player {} was interrupted while waiting.", player.getName());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            logger.info("Player {} joined the battle!", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers == 0) {
                logger.error("There are no players on the battlefield.");
                return;
            }
            logger.info("Player {} leaved the battle.", player.getName());
            currentPlayers--;
            lock.notify();
        }
    }
}
