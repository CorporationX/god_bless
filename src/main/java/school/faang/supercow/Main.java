package school.faang.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        List<Player> players = List.of(new Player("игрок 1"), new Player("игрок 2"),
                new Player("игрок 3"), new Player("игрок 4"));

        ExecutorService executor = Executors.newFixedThreadPool(4);
        players.forEach((player -> executor.submit(() -> player.doBattle(boss))));
        executor.shutdown();

    }
}
