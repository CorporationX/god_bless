package school.faang.BJS2_36994;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();
    private static final Logger log = LoggerFactory.getLogger(Boss.class);

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info(player.getName() + " ждет свободного слота для боя...");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error(player.getName() + " отключился от сервера");
                    return;
                }
            }
            currentPlayers++;
            log.info(player.getName() + " присоединился к бою");
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info(player.getName() + " покинул бой");
            lock.notify();
        }
    }
}
