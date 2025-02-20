package school.faang.supercow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Boss {

    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public Boss(int maxplayers) {
        this.maxPlayers = maxplayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            try {
                while (currentPlayers >= maxPlayers) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                log.error("ошибка! {} был прирван во время ожижание!", player.getName());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            currentPlayers++;
            log.info("{} присоединлся к сражению с боссом", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} - завершил сражение с боссом! теперь доступны новые слоты!", player.getName());
            lock.notify();
        }
    }
}