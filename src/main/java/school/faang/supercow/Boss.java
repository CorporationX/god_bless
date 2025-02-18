package school.faang.supercow;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Boss {

    private static final Logger LOGGER = LoggerFactory.getLogger(Boss.class);
    private final Object lock = new Object();

    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    LOGGER.info("{} ожидает, когда сможет вступить в бой!", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    LOGGER.error("Поток прерван во время ожидания: {}", e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
            currentPlayers++;
            LOGGER.info("Игрок {} вошел в битву!", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            LOGGER.info("Игрок {} покидает битву с боссом", player.getName());
            lock.notify();
        }
    }
}
