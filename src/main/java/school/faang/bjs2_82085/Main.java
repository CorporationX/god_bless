package school.faang.bjs2_82085;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 3;
    private static Boss worldBoss = new Boss(2);

    public static void main(String[] args) {
        Player ubivator228 = new Player("ubivator228");
        Player sweetCat = new Player("SweetCat");
        Player badHealer = new Player("BadHealer");

        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        executorService.execute(() -> ubivator228.doBattle(worldBoss));
        executorService.execute(() -> sweetCat.doBattle(worldBoss));
        executorService.execute(() -> badHealer.doBattle(worldBoss));

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("Битва еще не завершена");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
    }
}
