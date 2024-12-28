package school.faang.bjs249600;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Boss {

    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        try {
            while (currentPlayers >= maxPlayers) {
                player.wait();
                log.info("The player waiting for a slot to open up");
            }
            currentPlayers++;
            log.info("The player {} joined to the battle", player.name());
        } catch (InterruptedException e) {
            log.error("The tread was interrupted {}", e.getMessage());
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("The player {} left the battle", player.name());
        notifyAll();
    }
}