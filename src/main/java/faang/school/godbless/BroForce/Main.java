package faang.school.godbless.BroForce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_OF_THREADS = 3;

    private static final ExecutorService execute = Executors.newFixedThreadPool(NUM_OF_THREADS);

    public static void main(String[] args) {
        List<Player> players = getPlayers();
        Game game = new Game(players);
        startGame(game);
        execute.shutdown();
    }

    public static void startGame(Game game) {
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            execute.submit(game::update);
        }
    }

    public static List<Player> getPlayers() {
        return List.of(
                new Player("bro_1", 9),
                new Player("bro_2", 10),
                new Player("bro_3", 11)
        );
    }
}
