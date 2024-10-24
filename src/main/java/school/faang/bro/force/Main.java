package school.faang.bro.force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) {
        Game game = new Game(3);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < 4; i++) {
            executor.submit(() -> game.update(new Update(true, true)));
        }
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> game.update(new Update(true, false)));
        }
        executor.shutdown();
    }
}
