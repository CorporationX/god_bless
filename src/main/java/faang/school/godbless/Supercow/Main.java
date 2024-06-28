package faang.school.godbless.Supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(7);

        Boss boss = new Boss(3);

        getPlayers().forEach((player) -> executor.submit(() -> player.startBattle(boss)));
        executor.shutdown();
    }

    public static List<Player> getPlayers() {
        return List.of(
                new Player("p1"),
                new Player("p2"),
                new Player("p3"),
                new Player("p4"),
                new Player("p5"),
                new Player("p6"),
                new Player("p7")
        );
    }
}
