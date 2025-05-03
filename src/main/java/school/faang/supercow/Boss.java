package school.faang.supercow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Boss {
    @Getter
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("{} is waiting to join the battle...", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.warn("{} was interrupted while waiting.", player.getName());
                    return;
                }
            }

            currentPlayers++;
            log.info("{} has joined the battle. Current players: {}/{}",
                    player.getName(), currentPlayers, maxPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("{} has left the battle. Current players: {}/{}",
                    player.getName(), currentPlayers, maxPlayers);
            lock.notify();
        }
    }
}
