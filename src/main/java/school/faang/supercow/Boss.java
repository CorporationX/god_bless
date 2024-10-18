package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {

    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        if (maxPlayers < 1) {
            throw new IllegalArgumentException("Max players must be greater than 0");
        }
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers == maxPlayers) {
            try {
                log.info("Player {} is waiting", player);
                this.wait();
            } catch (InterruptedException e) {
                log.error("Caught exception", e);
                throw new IllegalStateException(
                        String.format("Thread %s interrupted", Thread.currentThread().getName()), e
                );
            }
        }
        currentPlayers++;
        log.info("Player {} joined the battle", player);
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers == maxPlayers) {
            this.notify();
        }
        currentPlayers--;
        log.info("Player {} left the battle", player);
    }
}
