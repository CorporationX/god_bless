package faang.school.godbless.Supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Battle {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        List<Player> players = List.of(new Player("1"), new Player("2"), new Player("3"), new Player("4"), new Player("5"));
        Boss boss = new Boss(3);

        players.forEach(player -> executor.submit(() -> player.startBattle(boss)));
        executor.shutdown();
    }
}