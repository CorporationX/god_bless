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
                synchronized (lock) {
                    currentPlayers.put(player.getId(), player);
                    System.out.printf("%s join the battle!%n", player.getName());
                    System.out.println("Players : " + currentPlayers.size());
                }
            } else {
                synchronized (lock) {
                    try {
                        System.out.println("No available slot in battle, please wait...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Server error: " + e.getMessage());
                    }
                }
            }
        }
        try {
            Thread.sleep(1000L * (RANDOM.nextInt(4) + 1));
            synchronized (lock) {
                currentPlayers.remove(player.getId());
                lock.notifyAll();
                System.out.printf("%s leave the battle%n", player.getName());
            }
        } catch (InterruptedException e) {
            System.out.println("Connection lost");
            throw new RuntimeException(e);
        }
    }
}
