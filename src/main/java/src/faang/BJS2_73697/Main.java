package src.faang.BJS2_73697;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int INITIAL_LIVES_COUNT = 3;
    private static final int THREADS_COUNT = 4;

    public static void main(String[] args) {
        final List<Player> players = List.of(
                new Player("P1", INITIAL_LIVES_COUNT, 0),
                new Player("P2", INITIAL_LIVES_COUNT, 0)
        );

        final Game game = new Game(players);
        final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            executor.execute(game::update);
        }

        executor.shutdown();
    }
}
