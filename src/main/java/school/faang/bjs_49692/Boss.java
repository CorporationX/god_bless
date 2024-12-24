package school.faang.bjs_49692;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private final Object lock = new Object();
    private int currentPlayers;
    @Getter
    private int totalPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (!hasFreeSlots()) {
                try {
                    log.info("Waiting. Max players: {}. Current players: {}", maxPlayers, currentPlayers);
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("Thread was interrupted", e);
                }
            }
            currentPlayers++;
            totalPlayers++;
            log.info("Current players: {}", currentPlayers);
        }
        log.info("Player {} joined the battle", player);
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            lock.notify();
        }
        log.info("Player {} left the battle", player);
    }

    private boolean hasFreeSlots() {
        return maxPlayers - currentPlayers > 0;
    }

}
