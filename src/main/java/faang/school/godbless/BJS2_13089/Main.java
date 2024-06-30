package faang.school.godbless.BJS2_13089;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(createPlayers());
        int threadsNumber = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);

        executorService.submit(() -> {
            try {
                while (game.isAllAlive()) {
                    game.update();
                }
                game.gameOver();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
    }

    private static List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            players.add(new Player("Player " + (i + 1)));
        }
        return players;
    }
}
