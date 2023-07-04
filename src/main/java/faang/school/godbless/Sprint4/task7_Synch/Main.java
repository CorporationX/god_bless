package faang.school.godbless.Sprint4.task7_Synch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(15);

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executor.submit(game::update);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
