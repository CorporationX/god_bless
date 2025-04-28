package supercow;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Boss {
    @Setter
    private int maxPlayers = 5;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (Objects.isNull(player)) {
            log.error("Null argument!");
            return;
        }

        while (currentPlayers == maxPlayers) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                log.error("Thread is interrupted!" + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers++;
        log.info("Player {} join the battle with boss...", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        if (Objects.isNull(player)) {
            log.error("Null argument!");
            return;
        }
        currentPlayers--;
        this.notify();
        log.info("Player {} leave the battle with boss...", player.getName());
    }
}
