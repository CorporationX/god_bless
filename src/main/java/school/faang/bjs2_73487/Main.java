package school.faang.bjs2_73487;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int TIMEOUT = 35;
    private static final int THREADS = 4;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

    public static void executeBossBattle(Boss boss) {
        IntStream.range(1, 10).forEach(i ->
                executorService.execute(() -> {
                    new Player().doBattle(boss);
                })
        );
    }

    public static void main(String[] args) throws InterruptedException {
        Boss lichKing = new Boss(3);
        executeBossBattle(lichKing);
        Boss onyxia = new Boss(4);
        executeBossBattle(onyxia);
        Boss chess = new Boss(1);
        executeBossBattle(chess);
        Boss opera = new Boss(5);
        executeBossBattle(opera);

        executorService.shutdown();
        if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}