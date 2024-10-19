package school.faang.Supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game {
    public static void main(String[] args) {
        Boss medusa = new Boss("Medusa", 2);

        ExecutorService service = Executors.newFixedThreadPool(8);

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");
        Player player5 = new Player("Player 5");
        Player player6 = new Player("Player 6");
        Player player7 = new Player("Player 7");
        Player player8 = new Player("Player 8");

        List<Player> players = new ArrayList<>(List.of(player1, player2, player3, player4, player5, player6, player7, player8));

        players.forEach(e -> service.submit(() -> e.startBattle(medusa)));

        service.shutdown();

        try {
            if (!service.awaitTermination(30, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Something went wrong", e);
        }


    }
}
