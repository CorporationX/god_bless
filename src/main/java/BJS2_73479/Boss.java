package BJS2_73479;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("{} Waiting for a free slot to fight the boss.", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.info("Battle interrupted!");
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("the method was interrupted");
                }
            }
            currentPlayers++;
            log.info("{} joined the battle!", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} left the battle!", player.getName());
            lock.notifyAll();
        }
    }
}
