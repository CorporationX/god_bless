package Supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            players.add(new Player("Player" + i, boss));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (Player player : players) {
            executorService.submit(player);
        }
        executorService.shutdown();

    }
}
