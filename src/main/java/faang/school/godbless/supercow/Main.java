package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 2;
    private static List<Player> allPlayers = List.of(new Player("Nik"),
            new Player("Andrey"),
            new Player("Vika"),
            new Player("Sasha"));

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Oleg"));
        players.add(new Player("Nikita"));

        Boss boss = new Boss(3, players);

        startBattle(boss);
    }

    private static void startBattle(Boss boss) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (Player player : allPlayers) {
            executor.submit(() -> {
                player.joinBattle(boss);
            });
        }
        executor.shutdown();
        endBattle(boss);
    }

    private static void endBattle(Boss boss) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        List<Player> playersCopy = new ArrayList<>(boss.getCurrentPlayers());

        for (Player player : playersCopy) {
            executor.submit(() -> {
                player.leaveBattle(boss);
            });
        }
        executor.shutdown();
    }
}
