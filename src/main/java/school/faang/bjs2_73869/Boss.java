package school.faang.bjs2_73869;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers < maxPlayers) {
            currentPlayers++;
            log.info("Player {} was added to the fight", player.getName());
        } else {
            try {
                log.info("All slots in battle are locked. Please wait...");
                wait();
            } catch (InterruptedException e) {
                log.error("Interrupted exception with message {} was thrown", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Player {} left the battle", player.getName());
        notify();
    }
}