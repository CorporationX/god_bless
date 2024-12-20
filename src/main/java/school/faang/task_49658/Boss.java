package school.faang.task_49658;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    public static final Logger LOGGER = LoggerFactory.getLogger(Boss.class);

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            LOGGER.debug("Персонаж {} ждет свободного слота для сражения!", player.getName());
            wait();
        }
        currentPlayers++;
        LOGGER.debug("Персонаж {} начал сражение с босом!", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        LOGGER.debug("{} завершил сражение с боссом!", player.getName());
        notifyAll();
    }
}
