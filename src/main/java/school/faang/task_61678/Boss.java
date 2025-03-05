package school.faang.task_61678;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers;

    private int currentPlayers;

    public void joinBattle(Player player) {
        final String playerName = player.getName();

        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("Player: {}, Status: Waiting, Free Slots: {}", playerName, getFreeSlots());
                    lock.wait();
                    log.info("Player: {}, Status: Awakened, Free Slots: {}", playerName, getFreeSlots());
                } catch (InterruptedException e) {
                    log.error(
                            "Player: {}, Status: Interrupted while waiting, Free Slots: {}",
                            playerName,
                            getFreeSlots());
                    Thread.currentThread().interrupt();
                }
            }

            currentPlayers++;
            log.info("Player: {}, Status: Joined, Free Slots: {}", playerName, getFreeSlots());
            lock.notifyAll();
        }
    }

    public void leaveBattle(Player player) {
        final String playerName = player.getName();
        synchronized (lock) {
            currentPlayers--;
            log.info("Player: {}, Status: Left, Free Slots: {}", playerName, getFreeSlots());
            lock.notifyAll();
        }
    }

    private int getFreeSlots() {
        synchronized (lock) {
            return maxPlayers - currentPlayers;
        }
    }
}
