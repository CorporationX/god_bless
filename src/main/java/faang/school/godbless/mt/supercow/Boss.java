package faang.school.godbless.mt.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final Object lock = new Object();
    private final int maxPlayersCount;
    private int currentPlayersCount;

    public Boss(int maxPlayersCount) {
        this.maxPlayersCount = maxPlayersCount;
        this.currentPlayersCount = 0;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (currentPlayersCount >= maxPlayersCount) {
                log.info("Player {} started waiting boss", player.getName());
                lock.wait();
            }
            currentPlayersCount++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayersCount > 0) {
                log.info("Player {} leave boss", player.getName());
                currentPlayersCount--;
                lock.notifyAll();
            }
        }
    }
}
