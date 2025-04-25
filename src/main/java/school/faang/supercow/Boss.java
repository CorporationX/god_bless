package school.faang.supercow;

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
                    log.info("{} ждет свободного слота для сражения с боссом.", player.name());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.info("{} был прерван во время ожидания.", player.name());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            log.info("{} присоединился к сражению с боссом!", player.name());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} завершил сражение с боссом!", player.name());
            lock.notify();
        }
    }
}
