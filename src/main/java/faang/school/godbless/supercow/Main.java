package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
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
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (Player player : allPlayers) {
            executor.submit(() -> {
                boss.joinBattle(player);
            });
        }
        executor.shutdown();
        endBattle(boss);
    }

    private static void endBattle(Boss boss) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Player> playersCopy = new ArrayList<>(boss.getCurrentPlayer());

        for (Player player : playersCopy) {
            executor.submit(() -> {
                boss.leaveBattle(player);
            });
        }
        executor.shutdown();
    }
}
