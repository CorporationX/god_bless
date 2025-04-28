package school.faang.bjs273505;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class Boss {
    private final String name;
    private final int maxPlayersCount;
    private int currentPlayersCount = 0;

    public void joinBattle(Player player) {
        synchronized (this) {
            while (calcAvailableSlots() <= 0) {
                try {
                    log.info("No available slots for \"{}\". Waiting...", player.getName());
                    this.wait();
                } catch (InterruptedException e) {
                    log.error("Thread interrupted while waiting for {}", player.getName());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            currentPlayersCount++;
            log.info("Player added in to battle \"{}\"", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (this) {
            currentPlayersCount--;
            log.info("Player left rhe battle \"{}\"", player.getName());
            this.notify();
        }
    }

    private int calcAvailableSlots() {
        return maxPlayersCount - currentPlayersCount;
    }
}
