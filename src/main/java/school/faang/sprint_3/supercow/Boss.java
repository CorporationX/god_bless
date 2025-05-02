package school.faang.sprint_3.supercow;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Boss {
    private final int maxPlayers = 6;
    private int currentPlayers;
    private final Object lock = new Object();

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            if (currentPlayers + 1 == maxPlayers) {
                lock.notify();
            }
            log.info("Player leave battle");
        }
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (maxPlayers == currentPlayers) {
                lock.wait();
            }
            currentPlayers++;
            log.info("Player join battle");
        }
    }
}
