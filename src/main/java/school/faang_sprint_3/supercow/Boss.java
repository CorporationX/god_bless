package school.faang_sprint_3.supercow;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Boss {
    public static final int MAX_PLAYERS = 2;

    public static int currentPlayersCount = 0;

    public synchronized void joinBattle(Player player) {
        if (currentPlayersCount < MAX_PLAYERS) {
            currentPlayersCount++;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("An exception occurred during wait()", e);
                throw new ThreadInterruptException("Thread was interrupted");
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
