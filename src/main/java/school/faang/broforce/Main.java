package school.faang.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 5);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> game.update(true, false));
        executorService.submit(() -> game.update(true, true));

        executorService.shutdown();
    }
}
