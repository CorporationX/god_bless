package school.faang.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(3);
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        Player player5 = new Player("Player5");
        List<Player> players = new ArrayList<>(List.of(player1, player2, player3, player4, player5));

        ExecutorService executor = Executors.newFixedThreadPool(players.size());
        players.forEach(player -> executor.submit(() -> player.startBattle(boss)));
        executor.shutdown();
    }
}
