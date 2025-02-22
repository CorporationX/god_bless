package BJS2_63369;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("Player {} is waiting for a free slot", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("Interrupted while waiting for a free slot", e);
                }
            }
            currentPlayers++;
            log.info("Player {} joined the battle", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("Player {} left the battle", player.getName());
            lock.notifyAll();
        }
    }
}
