package broForce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Game game = new Game(50, 50);

        for (int i = 0; i < 500; i++) {
            executorService.submit(()->{
                game.update(true, true);
            });
        }

        executorService.shutdown();
    }
}
