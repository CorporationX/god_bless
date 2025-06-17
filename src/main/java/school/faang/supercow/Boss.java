package school.faang.supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
@Slf4j
@RequiredArgsConstructor
public class Boss {

    private final Object lock = new Object();
    private final int maxPlayers;
    private int currentPlayers;

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers == maxPlayers) {
                try {
                    lock.wait();
                    log.info("Игрок {} ожидает свободный слот!", player.name());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток {} прерван", Thread.currentThread().getName(), e.getCause());
                }
            }
            currentPlayers++;
            log.info("Игрок {} вступил в бой!", player.name());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers != 0) {
                currentPlayers--;
                log.info("Игрок {} вышел из боя!", player.name());
                lock.notifyAll();
            }
        }
    }
}
