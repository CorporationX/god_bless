package school.faang.bjs2_73733;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                log.info("Player {} is waiting for the battle.", player.getName());
                this.wait();
            } catch (InterruptedException e) {
                log.error("Thread was interrupted. {}.", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        log.info("{} присоединился к сражению с боссом!", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Player {} left the battle.", player.getName());
        this.notifyAll();
    }
}
