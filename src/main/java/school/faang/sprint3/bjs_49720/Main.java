package school.faang.sprint3.bjs_49720;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(4);
        List<Player> players = initialize();
        ExecutorService executor = Executors.newFixedThreadPool(players.size());

        for (Player player : players) {
            executor.submit(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(300, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static List<Player> initialize() {
        List<Player> players = new ArrayList<>();
        String[] names = {"Sam", "Dan", "Nick", "Max", "John", "Owen", "Michael", "Van", "Billy"};

        for (String name : names) {
            players.add(new Player(name));
        }

        return players;
    }
}
