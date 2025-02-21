package school.faang.sprint.third.supercow;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object objectForLock = new Object();

    public void joinBattle(@NonNull Player player) {
        synchronized (objectForLock) {
            if (currentPlayers == maxPlayers) {
                try {
                    log.info("Player {} waiting for battle to join...", player.getName());
                    objectForLock.wait();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
            log.info("Player {} joined the battle!", player.getName());
            currentPlayers++;
        }
    }

    public void leaveBattle(@NonNull Player player) {
        synchronized (objectForLock) {
            if (currentPlayers == 0) {
                log.info("Hasn't players stop battle");
                return;
            }
            log.info("Player {} left the battle!", player.getName());
            currentPlayers--;
            objectForLock.notifyAll();
        }
    }
}
