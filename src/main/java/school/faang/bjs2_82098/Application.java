package school.faang.bjs2_82098;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> game.update(
                    Math.random() > 0.5,
                    Math.random() > 0.8
            ));
        }
        executor.shutdown();
    }
}
