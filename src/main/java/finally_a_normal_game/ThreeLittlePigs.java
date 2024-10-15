package finally_a_normal_game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreeLittlePigs {
    private static final int COUNT_PIGS = 3;
    private static final int TIME_IN_GAME = 30;
    private static ExecutorService executorService = Executors.newFixedThreadPool(COUNT_PIGS);

    /**
     * Main method of the program.
     * Starts three threads and waits for their end.
     * Prints "Игра окончена" if all threads are finished.
     * @param args the command line arguments
     * @throws InterruptedException if the waiting is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        executorService.submit(new Pig1Thread());
        executorService.submit(new Pig2Thread());
        executorService.submit(new Pig3Thread());

        executorService.shutdown();

        if (executorService.awaitTermination(TIME_IN_GAME, TimeUnit.SECONDS)) {
            System.out.println("Игра окончена");
        }
    }
}
