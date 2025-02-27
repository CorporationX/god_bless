package school.faang.task61643;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public void joinBattle(Player player) {
        synchronized (lock) {
            currentPlayers++;
            while (currentPlayers > maxPlayers) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Error lock waiting", e);
                }
            }
            log.info("Игрок {} успешно присоединился к сражению", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            lock.notify();
            log.info("Игрок {} покинул сражение", player.getName());
        }
    }
}
