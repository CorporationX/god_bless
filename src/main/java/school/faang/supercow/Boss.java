package school.faang.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Boss {
    private static final int MAX_PLAYERS = 3;
    private static final int PLAYERS_COUNT = 5;
    private final List<Player> currentPlayers = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(PLAYERS_COUNT);
        Boss boss = new Boss();

        for (int i = 1; i <= PLAYERS_COUNT; i++) {
            int copyI = i;
            executor.submit(() -> {
                Player player = new Player("player " + copyI);
                try {
                    player.battle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Mission complete");
        } else {
            System.out.println("Something went wrong...");
        }
    }

    public void joinBattle(Player player) {
        synchronized (this) {
            while (currentPlayers.size() >= MAX_PLAYERS) {
                System.out.println("Battlefield is full.");
                System.out.println("Player " + player.getName() + " is waiting");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers.add(player);
            System.out.println("Player " + player.getName() + " joined the battle");
        }
    }

    public void leaveBattle(Player player) {
        synchronized (this) {
            if (!currentPlayers.contains(player)) {
                throw new IllegalArgumentException("player is not on the battlefield");
            }
            currentPlayers.remove(player);
            System.out.println("Player " + player.getName() + " has left the battlefield");
            this.notify();
        }
    }
}
