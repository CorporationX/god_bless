package faang.school.godbless.broforce;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        Game game = new Game();
        List<Bro> bros = getBros();
        bros.forEach(game::addBro);
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        while (game.getActivePlayersCounter() > 0 && !game.isGameOver()) {
            executorService.submit(game::update);
        }
        executorService.shutdown();
    }

    private static List<Bro> getBros() {
        return List.of(
                new Bro("Rambro", 5),
                new Bro("Brominator", 9),
                new Bro("Brobocop", 4)
        );
    }
}