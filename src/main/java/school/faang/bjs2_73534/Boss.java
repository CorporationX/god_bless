package school.faang.bjs2_73534;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final Object lock = new Object();
    private final Integer maxPlayers;
    private final AtomicInteger currentPlayers = new AtomicInteger(0);

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers.get() >= maxPlayers) {
                try {
                    log.info("player {} is WAIT the battle", player.name());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("add player error {}", e.getMessage(), e);
                    Thread.currentThread().interrupt(); // Восстанавливаем флаг
                    return;
                }
            }
            log.info("player {} join to the battle", player.name());
            currentPlayers.incrementAndGet();
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            log.info("player {} leave the battle", player.name());
            currentPlayers.decrementAndGet();
            lock.notifyAll();
        }
    }
}
