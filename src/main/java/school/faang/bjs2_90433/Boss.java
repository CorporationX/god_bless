package school.faang.bjs2_90433;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Boss {

    private final int maxPlayers;
    private int currentPlayers;

    private final Object lock = new Object();

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.warn("{} waiting a empty place", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.warn("{}'s waiting was interrupted", player.getName());
                    Thread.currentThread().interrupt();
                }
            }
            currentPlayers++;
            log.info("{} join the battle! Current players: {}", player.getName(), currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} leave the battle!Current players: {}", player.getName(), currentPlayers);
            lock.notify();
        }
    }
}
