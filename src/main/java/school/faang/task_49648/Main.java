package school.faang.task_49648;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_PLAYERS = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);
        List<Player> players = new ArrayList<>();
        ExecutorService executor = Executors.newCachedThreadPool();

        addPlayersToGame(players);
        playGame(executor, boss, players);
    }

    private static void playGame(ExecutorService executor, Boss boss, List<Player> players) {
        players.forEach(player -> executor.submit(() -> player.startBattle(boss)));
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void addPlayersToGame(List<Player> players) {
        players.add(new Player("War"));
        players.add(new Player("Warlock"));
        players.add(new Player("Priest"));
        players.add(new Player("Paladin"));
        players.add(new Player("Shaman"));
        players.add(new Player("Hunter"));
        players.add(new Player("DeathKnight"));
    }
}
