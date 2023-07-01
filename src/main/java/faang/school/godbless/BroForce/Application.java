package faang.school.godbless.BroForce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() -> {
            for (int i = 0; game.getLives() > 0; i++) {
                game.update(i);
            }
        });
    }
}
