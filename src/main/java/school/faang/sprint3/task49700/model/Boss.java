package school.faang.sprint3.task49700.model;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final List<Player> battlePlayers = new ArrayList<>();
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (battlePlayers.size() >= maxPlayers) {
                log.info("{} is waiting for battle with Boss", player);
                lock.wait();
            }
            battlePlayers.add(player);
            currentPlayers = battlePlayers.size();
            log.info("{} joined to battle with Boss. Total players in battle: {}", player, currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (battlePlayers.remove(player)) {
                currentPlayers = battlePlayers.size();
                log.info("{} leave the battle with Boss. Total players in battle: {}", player, currentPlayers);
            }
        }
    }

    public void killEmAll() {
        synchronized (lock) {
            if (!battlePlayers.isEmpty()) {
                battlePlayers.clear();
                currentPlayers = 0;
                log.info("All players was killed by Boss");
                lock.notifyAll();
            }
        }
    }
}
