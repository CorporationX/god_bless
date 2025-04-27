package school.faang.bjs2_73886;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AMOUNT_OF_THREADS = 5;
    private static final int STARTING_LIVES = 4;
    private static final int MINUTES_TO_WAIT = 1;

    public static void main(String[] args) {
        Game game = new Game(STARTING_LIVES);
        ExecutorService threads = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);

        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            if (game.isRunning()) {
                threads.submit(new Thread(() -> game.update(1, 1)));
            }
        }

        threads.shutdown();
        try {
            if (!threads.awaitTermination(MINUTES_TO_WAIT, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за минуту, принудительно останавливаем...");
                threads.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Принудительное завершение работы");
            threads.shutdownNow();
        }
    }
}
