package bjs261487;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Boss {
    private static final Logger LOGGER = LoggerFactory.getLogger(Boss.class);
    private final int maxPlayers = 6;
    private int currentPlayers;
    private final Map<String, Player> nameToPlayer = new HashMap<>();
    private final Object lock = new Object();

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            validatePlayer(player);
            if (currentPlayers >= maxPlayers) {
                lock.wait();
            }
            currentPlayers++;
            nameToPlayer.put(player.getName(), player);
            LOGGER.info("Player {} has joined battle", nameToPlayer.get(player.getName()));
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            LOGGER.info("Player {} has left battle", nameToPlayer.get(player.getName()));
            nameToPlayer.remove(player.getName());
            lock.notify();
        }
    }

    private void validatePlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player shouldn't be null");
        }
        if (player.getName().isEmpty()) {
            throw new IllegalArgumentException("Player must have name");
        }
    }
}
