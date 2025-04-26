package school.faang.bjs2_73485;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Boss {

    private static final Object LOCK = new Object();

    private final int maxPlayers;
    private int currentPlayers;

    public void joinBattle(Player player) {
        synchronized (LOCK) {
            if (currentPlayers < maxPlayers) {
                log.info("Player -> {}, successfully joined the battle", player.getName());
                currentPlayers++;
            } else {
                try {
                    log.info("Player -> {}, is trying to join the fight but has to wait", player.getName());
                    LOCK.wait(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                joinBattle(player);
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (LOCK) {
            log.info("Player -> {}, has left the battle", player.getName());
            currentPlayers--;
            LOCK.notify();
        }
    }
}
