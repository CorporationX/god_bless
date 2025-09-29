package school.faang.bjs2_90419;

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
                    log.info("Waiting for free slots to fight");
                    lock.wait();
                }  catch (InterruptedException e) {
                    log.error("InterruptedException while waiting for player to join");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            currentPlayers++;
            log.info("Player {} joined the battle",  player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers > 0) {
                currentPlayers--;
                log.info("Player {} left the battle",  player.getName());
            }
            lock.notifyAll();
        }
    }
}
