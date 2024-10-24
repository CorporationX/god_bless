package school.faang.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final int NUMBER_OF_PLAYERS = 2;
        Game game = new Game(0, 3);

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_PLAYERS);

        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            executor.submit(game::update);
        }

        executor.shutdown();
    }
}
