package school.faang.supercowbjs49732;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private static final Logger logger =
            LoggerFactory.getLogger(Boss.class);

    public Boss(int maxPlayers) {
        if (maxPlayers <= 0) {
            throw new IllegalArgumentException("maxPlayers must be greater than 0");
        }
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                logger.info("{} waits until a slot is available...", player.getName());
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.warn("{} was interrupted", player.getName());
                return;
            }
        }
        currentPlayers++;
        logger.info("{} joined the fight! Current players: {}", player.getName(),
                currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        logger.info("{} completed the battle! Current players: {}", player.getName(),
                currentPlayers);
        notifyAll();
    }
}
