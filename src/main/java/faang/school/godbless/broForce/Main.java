package faang.school.godbless.broForce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Game game = new Game(0, 4);

        List<Player> players = List.of(new Player("player1", 10), new Player("player2", 20),
                new Player("player3", 30), new Player("player4", 40), new Player("player5",50));

        players.stream().forEach(player -> game.addPlayer(player));

        players.stream().forEach(player -> {
            executorService.execute(() -> {
                    game.update(player);
            });
        });
        executorService.shutdown();
    }
}