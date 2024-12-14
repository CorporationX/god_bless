package faang.school.godbless.modul3.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Boss boss = new Boss(3, new ArrayList<>());

        List<Player> players = List.of(
                new Player("Player 1st"),
                new Player("Player 2nd"),
                new Player("Player 3rd"),
                new Player("Player 4th"));

        players.forEach(player -> executorService.execute(() ->
                player.startBattle(boss)));
        executorService.shutdown();
    }
}
