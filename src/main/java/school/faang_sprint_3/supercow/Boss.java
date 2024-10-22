package school.faang_sprint_3.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayersCount = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayersCount < maxPlayers) {
            currentPlayersCount++;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("An exception occurred during wait()", e);
                throw new IllegalStateException("Thread was interrupted");
            }
        }
        endTheBattle(player);
    }

    public synchronized void endTheBattle(Player player) {
        log.info("{}: My battle ends here!", player.name());
        currentPlayersCount--;
        notify();
    }
}
