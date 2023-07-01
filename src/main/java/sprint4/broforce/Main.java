package sprint4.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREAD = 2;
    private static final Game GAME = new Game();
    private static final Runnable RUNNABLE = () -> {
        while (GAME.isGameContinues()) {
            GAME.update();
        }
    };

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREAD);
        service.execute(RUNNABLE);
        service.execute(RUNNABLE);
        service.shutdown();
    }
}
