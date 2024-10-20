package school.faang.Mnogopotochka.Synhronaized.BJS2_36782;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Boss {
    private static final Logger logger = LoggerFactory.getLogger(Boss.class);
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        if (maxPlayers <= 0) {
            throw new IllegalArgumentException("Максимальное количество игроков должно быть больше нуля.");
        }
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                logger.info("{} ждет, пока освободится слот.", player.getPlayerName());
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("{} был прерван.", player.getPlayerName());
            }
        }
        currentPlayers++;
        logger.info("{} присоединился к сражению.", player.getPlayerName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        logger.info("{} покинул сражение.", player.getPlayerName());
        notify();
    }
}
