package school.faang.bjs2_73485;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Boss {

    private final Object lock = new Object();
    private static final int THREAD_WAIT = 10000;

    private final int maxPlayers;
    private int currentPlayers;

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers < maxPlayers) {
                log.info("Player -> {}, successfully joined the battle", player.getName());
                currentPlayers++;
            } else {
                try {
                    log.info("Player -> {}, is trying to join the fight but has to wait", player.getName());
                    lock.wait(THREAD_WAIT);
                } catch (InterruptedException e) {
                    log.info("Thread {} has been interrupted!", Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
                joinBattle(player);
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            log.info("Player -> {}, has left the battle", player.getName());
            currentPlayers--;
            lock.notify();
        }
    }
}
