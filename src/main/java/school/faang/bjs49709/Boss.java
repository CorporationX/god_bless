package school.faang.bjs49709;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            synchronized (this) {
                wait();
                log.info("Player {} send to wait because limit reache", player.name());
            }
        }
        synchronized (this) {
            currentPlayers++;
        }
    }

    public synchronized void exitBattle(Player player) {
        currentPlayers--;
        notify();
    }
}
