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

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            log.info("Player {} send to wait because limit reached", player.name());
            wait();
        }
        log.info("{} entered boss {}", player.name(), this);
        currentPlayers++;
    }

    public synchronized void exitBattle(Player player) {
        currentPlayers--;
        log.info("{} exited boss {}", player.name(), this);
        notify();
    }
}
