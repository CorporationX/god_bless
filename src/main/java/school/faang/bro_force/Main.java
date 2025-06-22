package school.faang.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            if (game.getLives() <= 0) {
                break;
            }
            int score = Math.toIntExact(Math.round(15.3));
            int live = 1;
            executorService.submit(() -> game.update(score, live));
        }
        executorService.shutdown();
    }
}
