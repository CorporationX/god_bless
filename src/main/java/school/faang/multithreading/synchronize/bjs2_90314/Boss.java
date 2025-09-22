package school.faang.multithreading.synchronize.bjs2_90314;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Boss {
    private static final int MAX_PLAYERS = 10;
    private static int currentPlayers = 0;
    private final Object lock;

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers >= MAX_PLAYERS) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            currentPlayers++;
            System.out.printf("Player %s joined the game%n", player.name());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            lock.notify();
            System.out.printf("Player %s left the game%n", player.name());
        }
    }
}