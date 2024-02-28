package faang.school.godbless.r_edzie.synchronization.force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_AMOUNT = 3;
    private static final int TERMINATION_TIMEOUT = 5;

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Bro firstBro = new Bro("1", 5, true);
        Bro secondBro = new Bro("2", 10, true);

        game.addBro(firstBro);
        game.addBro(secondBro);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

        for (int i = 0; i < game.getBros().size(); i++) {
            executorService.submit(() -> {
                while (game.isOver()) {
                    game.update();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS);

    }
}
