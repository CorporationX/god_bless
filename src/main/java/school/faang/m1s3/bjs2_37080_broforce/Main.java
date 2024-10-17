package school.faang.m1s3.bjs2_37080_broforce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Brobocop"),
                new Player("Brominator"),
                new Player("Brambo"),
                new Player("Chuck Broris"),
                new Player("Bro Lee")
        );

        Game game = new Game(players);

        ExecutorService gameService = Executors.newFixedThreadPool(game.getPlayerList().size());

        game.startGame(gameService);

        try {
            if (!gameService.awaitTermination(30, TimeUnit.SECONDS)) {
                gameService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }

        game.gameOver();
    }
}
