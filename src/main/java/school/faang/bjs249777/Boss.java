package school.faang.bjs249777;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(List<Player> players, int maxPlayers) {
        this.currentPlayers = players.size();
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        tryToJoin();
        log.info("Player {} joined the battle", player.getName());
        currentPlayers++;
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Player {} left the battle", player.getName());
        this.notifyAll();
    }

    private synchronized void tryToJoin() {
        log.info("Check for available slots");
        if (!isSlotAvailable()) {
            try {
                log.info("Waiting for available slots");
                this.wait();
                log.info("Notify received for available slots");
                tryToJoin();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }

        log.info("Slot available!");
    }

    private boolean isSlotAvailable() {
        return currentPlayers < maxPlayers;
    }
}
