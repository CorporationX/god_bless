package faang.school.godbless.force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        Game game = new Game(1000);
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> game.update());
        }
        executor.shutdown();
    }
}
