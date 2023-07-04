package faang.school.godbless.BroForce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        Player player1 = new Player("Player1", 50, 0);
        Player player2 = new Player("Player2", 50, 0);
        Player player3 = new Player("Player3", 50, 0);
        Player player4 = new Player("Player4", 50, 0);
        Game game = new Game(List.of(player1, player2, player3, player4));
        ExecutorService executorService = Executors.newFixedThreadPool(game.getPlayers().size());

        executorService.execute(() -> {
            int i = 0;
            while (game.isGameIsNotOver()) {
                game.update(i++);
            }
        });

        executorService.shutdown();
    }
}
