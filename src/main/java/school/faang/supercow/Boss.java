package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("The thread was interrupted", e);
                }
            }
            currentPlayers++;
            log.info("{} joined the battle", player);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} left the battle", player);
            lock.notify();
        }
    }
}
