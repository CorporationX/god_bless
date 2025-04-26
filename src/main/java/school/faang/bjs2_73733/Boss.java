package school.faang.bjs2_73733;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers < maxPlayers) {
            currentPlayers++;
            log.info("Player {} joind the battle.", player.getName());
        } else {
            try {
                log.info("Player {} is waiting for the battle.", player.getName());
                this.wait();
            } catch (InterruptedException e) {
                log.error("Thread was interrupted. {}.", e.getMessage());
            }
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Player {} left the battle.", player.getName());
        this.notifyAll();
    }
}
