package school.faang.bjs2_82094_supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final List<Player> playerList = new ArrayList<>();

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            log.info("Cannot add player {}, waiting for a spot", player);
            wait();
        }

        currentPlayers++;
        playerList.add(player);
        log.info("Added player {}", player);
    }

    public synchronized void leaveBattle(Player player) {
        if (playerList.contains(player)) {
            currentPlayers--;
            playerList.remove(player);
            log.info("Player {} left", player);
        } else {
            log.warn("Attempt to remove player {} who is not in the battle", player);
        }
        notify();
    }

}
