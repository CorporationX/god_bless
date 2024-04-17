package supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(1);
        List<Player> players = new ArrayList<>();

        for (int i = 0; i<20; i++) {
            players.add(new Player("Player " + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        players.forEach(player -> executor.execute(() -> player.startBattle(boss)));

        executor.shutdown();
    }
}
