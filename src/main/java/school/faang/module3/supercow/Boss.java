package school.faang.module3.supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers++;
        log.info("Player {} was added to battle", player.name());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Player {} leaved the battle", player.name());
        notifyAll();
    }
}
