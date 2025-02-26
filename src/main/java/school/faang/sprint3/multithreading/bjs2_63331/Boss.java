package school.faang.sprint3.multithreading.bjs2_63331;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.warn("\nThread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers++;
        System.out.printf("\nPlayer %s joined the battle  |  Players are in the battle: %d", player.getName(),
                currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.printf("\n-> Player %s left the battle  |  Players are in the battle: %d", player.getName(),
                currentPlayers);
        notify();
    }
}
