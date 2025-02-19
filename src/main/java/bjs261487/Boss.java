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
    private static int currentPlayers = 0;
    private static final Map<String, Player> NAME_TO_PLAYER = new HashMap<>();
    private final Object lock = new Object();

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            validatePlayer(player);
            if (currentPlayers >= maxPlayers) {
                lock.wait();
            }
            currentPlayers++;
            NAME_TO_PLAYER.put(player.getName(), player);
            LOGGER.info("Player {} has joined battle", NAME_TO_PLAYER.get(player.getName()));
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            LOGGER.info("Player {} has left battle", NAME_TO_PLAYER.get(player.getName()));
            NAME_TO_PLAYER.remove(player.getName());
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
