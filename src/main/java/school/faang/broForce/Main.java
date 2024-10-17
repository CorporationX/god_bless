package school.faang.broForce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        Game game = new Game();
        Player mario = new Player("Mario", 3);
        Player luigino = new Player("Luigino", 4);
        Player pitch = new Player("Pitch", 2);
        Player bowser = new Player("Bowser", 5);
        List<Player> players = List.of(mario, luigino, pitch, bowser);
        game.addLotsPlayers(players);

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        executor.submit(() -> {
            while (!game.update()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
    }
}