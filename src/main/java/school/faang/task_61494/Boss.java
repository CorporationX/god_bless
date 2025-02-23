package school.faang.task_61494;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Boss {
    private static final Logger LOG = LoggerFactory.getLogger(Boss.class);
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
                    LOG.info("The slots for the boss are all occupied ({}/{}).", currentPlayers, maxPlayers);
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Thread was interrupted while waiting", e);
                }
            }
            LOG.info("The boss has a free slot ({}/{}). Adding new player {} to the battle!",
                    currentPlayers, maxPlayers, player.getName());
            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            LOG.info("The player {} has left the battle.", player.getName());
            lock.notify();
        }
    }
}
