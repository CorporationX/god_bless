package faang.school.godbless.Supercow;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Slf4j
public class Boss {
    private int maxPlayers;
    private final Set<Player> currentPlayers = new HashSet<>();

    public boolean joinBattle(Player player) {
        synchronized (currentPlayers) {
            try {
                while (currentPlayers.size() >= maxPlayers) {
                    currentPlayers.wait();
                }
                currentPlayers.add(player);
                return true;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(e.getMessage());
                return false;
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (currentPlayers) {
            if (currentPlayers.remove(player)) {
                log.info("Player {} has left the battle.", player.getName());
                currentPlayers.notifyAll();
            }
        }
    }
}

