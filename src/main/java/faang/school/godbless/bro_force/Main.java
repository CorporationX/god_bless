package faang.school.godbless.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player[] players = new Player[]{
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4"),
                new Player("Player 5"),
                new Player("Player 6"),
                new Player("Player 7"),
                new Player("Player 8"),
        };

        for (Player player : players) {
            game.addPlayer(player);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i <= 10; i++) {
            executorService.execute(game::update);
        }

        executorService.shutdown();
    }
}
