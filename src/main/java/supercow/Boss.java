package supercow;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Boss {
    @Setter
    private int maxPlayers = 5;
    private int currentPlayers;

    public void joinBattle(Player player) {
        synchronized (this) {
            if (Objects.isNull(player)) {
                log.error("Null argument!");
                return;
            }

            if (currentPlayers == maxPlayers) {
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
    }

    public void leaveBattle(Player player) {
        synchronized (this) {
            if (Objects.isNull(player)) {
                log.error("Null argument!");
                return;
            }
            currentPlayers--;
            this.notify();
            log.info("Player {} leave the battle with boss...", player.getName());
        }
    }
}
