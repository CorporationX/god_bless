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
@AllArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final List<Player> players = new ArrayList<>();

    public synchronized void joinBattle(Player player) {
        while (currentPlayers == maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("the player {} interrupted the boss battle", player, e);
            }
        }
        players.add(player);
        currentPlayers++;
        log.info("the player {} has been added to the boss battle", player);
    }

    public synchronized void leaveBattle(Player player) {
        players.remove(player);
        currentPlayers--;
        notify();
        log.info("the player {} left for the boss fight", player);
    }
}
