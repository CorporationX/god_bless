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
            try {
                if (currentPlayers >= maxPlayers) {
                    lock.wait();
                }
                currentPlayers++;
                log.info("{} joined the battle!", player.getName());
            } catch (InterruptedException e) {
                log.info("Battle interrupted!");
                throw new IllegalStateException("the method was interrupted");
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} left the battle!", player.getName());
            lock.notify();
        }
    }
}
