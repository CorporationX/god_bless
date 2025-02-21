package school.faang.sprint3.multithreading.bjs2_63331;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public void joinBattle(Player player) {
        synchronized(this) {
            while (currentPlayers < maxPlayers) {
                currentPlayers++;
            }

            try {
                wait();
            } catch (InterruptedException e) {
                log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            }
        }
    }

    public void leaveBattle(Player player) {
       synchronized (this) {
            currentPlayers--;
            notify();
        }
    }
}
