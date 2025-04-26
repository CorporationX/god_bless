package school.faang.bjs2_73487;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void executeBossBattle(Boss boss) {
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    new Player().doBattle(boss);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
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
        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}