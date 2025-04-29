package school.faang.bjs2_73621;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("Waiting for free slots for player {}", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("The thread was interrupted while waiting for free slots", e);
                }
            }
            currentPlayers++;
            log.info("Player {} joined battle", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("Player {} left battle", player.getName());
            lock.notifyAll();
        }
    }
}
