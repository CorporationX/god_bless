package school.faang.bjs2_90336;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Boss {
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
                    log.info("{} - ждет свободного слота для сражения с боссом.", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("{} - был прерван во время ожидания.", player.getName());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            log.info("{} - присоединился к сражению с боссом!", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} - завершил сражение с боссом!", player.getName());
            lock.notify();
        }
    }
}
