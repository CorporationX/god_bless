package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers = 4;
    private int currentPlayers = 0;

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("Ожидание освобождения слота");
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("Игрок {} был прерван во время ожидания", player.getName());
                    Thread.currentThread().interrupt();
                }
            }
            currentPlayers++;
            log.info("{} присоединился к сражению с боссом!", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} завершил сражение с боссом!", player.getName());
            lock.notifyAll();
        }
    }
}
