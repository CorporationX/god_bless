package supercow;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    @NonNull
    private final Object lock;
    private static final Random RANDOM = ThreadLocalRandom.current();
    private final int maxPlayers;
    @NonNull
    private final Map<Integer, Player> currentPlayers = new HashMap<>();

    public void joinBattle(@NonNull Player player) {
        synchronized (lock) {
            if (currentPlayers.size() < maxPlayers) {
                addPlayer(player);
            } else {
                try {
                    log.info("No available slot in battle, please wait...");
                    while (maxPlayers <= currentPlayers.size()) {
                        lock.wait();
                    }
                    addPlayer(player);
                } catch (InterruptedException e) {
                    log.info("Server error: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
        processPlayerBattle(player);
    }

    private void addPlayer(@NonNull Player player) {
        currentPlayers.put(player.getId(), player);
        log.info(String.format("%s join the battle!%n", player.getName()));
        printCountOfCurrentPlayers();
    }

    private void removePlayer(@NonNull Player player) {
        currentPlayers.remove(player.getId());
        log.info(String.format("%s leave the battle%n", player.getName()));
        printCountOfCurrentPlayers();
    }

    private void processPlayerBattle(@NonNull Player player) {
        try {
            Thread.sleep(1000L * (RANDOM.nextInt(4) + 1));
            synchronized (lock) {
                removePlayer(player);
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            log.info("Connection lost");
            Thread.currentThread().interrupt();
        }
    }

    private void printCountOfCurrentPlayers() {
        log.info("Players : " + currentPlayers.size());
    }
}
