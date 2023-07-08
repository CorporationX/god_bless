package faang.school.godbless.Supercow;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Battleground {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        List<Player> players = createPlayers();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        createPlayers().forEach(player ->
                executorService.execute(() -> player.startBattle(boss)));

        executorService.shutdown();
    }

    public static List<Player> createPlayers() {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        Player player5 = new Player("Player5");
        Player player6 = new Player("Player6");
        Player player7 = new Player("Player7");
        return List.of(player1, player2, player3,
                player4, player5, player6, player7);
    }
}
