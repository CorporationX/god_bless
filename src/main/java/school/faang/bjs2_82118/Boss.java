package school.faang.bjs2_82118;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    @Getter
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("Player \"{}\" needs to wait while another player leaves the battle.", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("InterruptedException", e);
                    Thread.currentThread().interrupt();
                }
            }
            currentPlayers++;
            log.info("Player \"{}\" joined the battle", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("Player \"{}\" left the battle", player.getName());
            lock.notify();
        }
    }
}
