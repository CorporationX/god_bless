package faang.school.godbless.task.multithreading.supercow;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final static int LOBBY_SIZE = 2;

    public static void main(String[] args) {
        var players = List.of(
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4"),
                new Player("Player 5"),
                new Player("Player 6"),
                new Player("Player 7")
        );
        var boss = new Boss(LOBBY_SIZE, new HashSet<>());
        ExecutorService executor = Executors.newCachedThreadPool();
        players.forEach(player -> executor.submit(() -> player.startBattle(boss)));
        executor.shutdown();
    }
}
