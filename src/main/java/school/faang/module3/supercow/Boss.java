package school.faang.module3.supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public void joinBattle(Player player) {
        synchronized (this) {
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
                log.info("Player {} was added to battle", player.name());
            } else {
                log.info("Player {} need to wait to join battle", player.name());
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (this) {
            if (currentPlayers > 0) {
                currentPlayers--;
                log.info("Player {} leaved the battle", player.name());
                this.notifyAll();
            }
        }
    }
}
