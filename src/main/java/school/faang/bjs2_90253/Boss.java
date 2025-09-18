package school.faang.bjs2_90253;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private List<Player> players = new ArrayList<>();
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers == maxPlayers) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("the player {} interrupted the boss battle", player, e);
                }
            }
            players.add(player);
            currentPlayers++;
            log.info("the player {} has been added to the boss battle", player);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            players.remove(player);
            lock.notify();
            log.info("the player {} left for the boss fight", player);
        }
    }
}
