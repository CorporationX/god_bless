package school.faang.bjs2_73534;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final Object lock = new Object();
    private final Integer maxPlayers;
    private Integer currentPlayers = 0;

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers >= maxPlayers) {
                try {
                    log.info("player {} is WAIT the battle", player.name());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("add player error {}", e.getMessage(), e);
                    throw new RuntimeException(e);
                }
            }
            log.info("player {} join to the battle", player.name());
            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            log.info("player {} leave the battle", player.name());
            currentPlayers--;
            lock.notify();
        }
    }
}
