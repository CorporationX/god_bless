package supercow;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RequiredArgsConstructor
public class Boss {
    @NonNull
    private final Object lock;
    private static final Random RANDOM = new Random();
    private final int maxPlayers;
    @NonNull
    private final Map<Integer, Player> currentPlayers = new HashMap<>();

    public void joinBattle(@NonNull Player player) {
        synchronized (lock) {
            if (currentPlayers.size() < maxPlayers) {
                addPlayer(player);
            } else {
                waitForBattleSlot(player);
            }
        }
        processPlayerBattle(player);
    }

    private void addPlayer(@NonNull Player player) {
        currentPlayers.put(player.getId(), player);
        System.out.printf("%s join the battle!%n", player.getName());
        printCountOfCurrentPlayers();
    }

    private void removePlayer(@NonNull Player player) {
        currentPlayers.remove(player.getId());
        System.out.printf("%s leave the battle%n", player.getName());
        printCountOfCurrentPlayers();
    }

    private void waitForBattleSlot(@NonNull Player player) {
        synchronized (lock) {
            try {
                System.out.println("No available slot in battle, please wait...");
                lock.wait();
                addPlayer(player);
            } catch (InterruptedException e) {
                System.out.println("Server error: " + e.getMessage());
            }
        }
    }

    private void processPlayerBattle(@NonNull Player player) {
        try {
            Thread.sleep(1000L * (RANDOM.nextInt(4) + 1));
            synchronized (lock) {
                removePlayer(player);
                lock.notify();
            }
        } catch (InterruptedException e) {
            System.out.println("Connection lost");
            throw new RuntimeException(e);
        }
    }

    private void printCountOfCurrentPlayers() {
        System.out.println("Players : " + currentPlayers.size());
    }
}
